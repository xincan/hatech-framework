/**
 * @Author dingjianfei
 * @Date 2019/6/4
 * @Description:为Editable添加一个连线编辑框用来连线
 */
import Circle from '../../../renderer/graphic/shape/Circle'
import Arrow from '../../../renderer/graphic/shape/Arrow'
import Polygon from "../../../renderer/graphic/shape/Polygon";
import objUtil from '../../../../utilLib/Obj'
export default class {
	constructor(editable,container,opts) {
		this.__editable=editable;
		this.__opts=opts;
		this.__gd=container.__gd?container.__gd:container;
		this.__container=container;
		this.__zlevel=editable.zlevel+1;
		this.__addBoxGraph();
	}
	__circleR=5;
	__circleHoverWidth=2;
	__circleStyle={
		fill:"rgba(225,12,127,0.7)",
		stroke:'#9ee7fd',
		lineWidth:1
	};//拖拽圆点样式
	__rectStyle={
		fill:"rgba(225,225,225,0)",
		stroke:'#00A6FD',
		lineDash:[4,4],
		lineWidth:1
	};//拖拽轮廓样式

	//给编辑器用来配置事件
	_addEvent(fun) {
		for(let v of this.__boxGraphList){
			fun(v);
		}
	};
	__boxGraphList=[];//添加的图形
	__addBoxGraph(){
		var ep=this.__editable.getEditPosition();
		if(this.__container.transformCoordToLocal){
			ep={
				A: this.__container.transformCoordToLocal(ep.A[0], ep.A[1]),
				B: this.__container.transformCoordToLocal(ep.B[0], ep.B[1]),
				C: this.__container.transformCoordToLocal(ep.C[0], ep.C[1]),
				D: this.__container.transformCoordToLocal(ep.D[0], ep.D[1]),
				E: this.__container.transformCoordToLocal(ep.E[0], ep.E[1]),
				F: this.__container.transformCoordToLocal(ep.F[0], ep.F[1]),
				G: this.__container.transformCoordToLocal(ep.G[0], ep.G[1]),
				H: this.__container.transformCoordToLocal(ep.H[0], ep.H[1]),
				center: this.__container.transformCoordToLocal(ep.center[0], ep.center[1])
			}
		}
		var box=new Polygon({
			shape:{
				points:[[ep.A[0],ep.A[1]],[ep.B[0],ep.B[1]],[ep.C[0],ep.C[1]],[ep.D[0],ep.D[1]],]
			},
			zlevel: this.__zlevel-2
		});
		objUtil.deepMix(box,this.__opts.rect)
		this.__add(box);

		var top=new Circle({
			shape:{
				cx:ep.E[0],
				cy:ep.E[1],
			},
			linkEditNodeType:'top',
			cursor:'crosshair',
			zlevel: this.__zlevel
		});
		objUtil.deepMix(top,this.__opts.circle)
		this.__add(top);
		this.__addEvnet(top);

		var right=new Circle({
			shape:{
				cx:ep.F[0],
				cy:ep.F[1],
			},
			linkEditNodeType:'right',
			cursor:'crosshair',
			zlevel: this.__zlevel
		});
		objUtil.deepMix(right,this.__opts.circle)
		this.__add(right);
		this.__addEvnet(right);

		var bottom=new Circle({
			shape:{
				cx:ep.G[0],
				cy:ep.G[1],
			},
			linkEditNodeType:'bottom',
			cursor:'crosshair',
			zlevel: this.__zlevel
		});
		objUtil.deepMix(bottom,this.__opts.circle)
		this.__add(bottom);
		this.__addEvnet(bottom);

		var left=new Circle({
			shape:{
				cx:ep.H[0],
				cy:ep.H[1],
			},
			linkEditNodeType:'left',
			cursor:'crosshair',
			zlevel: this.__zlevel
		});
		objUtil.deepMix(left,this.__opts.circle)
		this.__add(left);
		this.__addEvnet(left);

		var intersect=new Circle({
			shape:{
				cx:ep.center[0],
				cy:ep.center[1]
			},
			cursor:'crosshair',
			linkEditNodeType:'intersect',
			zlevel: this.__zlevel
		});
		objUtil.deepMix(intersect,this.__opts.circle)
		this.__add(intersect);
		this.__addEvnet(intersect);

	}
	__add(graph){
		graph.unEdit=true;
		graph.isEditDisplay=true;
		graph.myEditable=this.__editable,
		this.__container.add(graph);
		this.__boxGraphList.push(graph);
	}
	__addEvnet(node){
		if(this.__editable.editDisabled){
			return;
		}
		node.on('mousedown',(e) =>{
			let displayArrow=null;
			let onMousemoveFun=(ee) => {
				let factXY={
					from: [e.offsetX,e.offsetY],
					to: [ee.offsetX,ee.offsetY],
				}

				//适当偏移指示箭头，防止触点时间被指示箭头遮挡
				if(factXY.to[0]>=factXY.from[0]){
					factXY.to[0]=factXY.to[0]-5
				}else{
					factXY.to[0]=factXY.to[0]+5
				}

				if(displayArrow==null){
					displayArrow=new Arrow({
						shape:{
							x1:factXY.from[0],
							y1:factXY.from[1],
							x2:factXY.to[0],
							y2:factXY.to[1],
							arrowLength:15,
							arrowAngle:20,
							arrowType:'solid'
						},
						style:{
							fill:"#000"
						},
						zlevel:this.__zlevel
					})
					this.__gd.add(displayArrow);
				}else{
					displayArrow.attr({
						shape:{
							x1:factXY.from[0],
							y1:factXY.from[1],
							x2:factXY.to[0],
							y2:factXY.to[1],
						}
					})
				}
			}
			let onMouseupFun=(ee) => {
				this.__gd.off('mousemove',onMousemoveFun);
				this.__gd.off('mouseup',onMouseupFun);
				document.removeEventListener("mouseup", onMouseupFun);
				if(displayArrow==null){
					return;
				}else{
					this.__gd.remove(displayArrow);
				}
				//在canvas内,且落在图形上
				if(ee.event&&ee.target){
					var linkData={}
					if(ee.target.linkEditNodeType){
						linkData={
							from:node.myEditable,
							to:ee.target.myEditable,
							linkPointsType:[node.linkEditNodeType,ee.target.linkEditNodeType]
						}
					}else if(ee.target.isEditable&&!ee.target.unEditLink){
						linkData={
							from:node.myEditable,
							to:ee.target,
							linkPointsType:[node.linkEditNodeType,'intersect']
						}
					}else{
						return
					}
					//不允许自己连自己
					if(linkData.from===linkData.to){
						return
					}
					//对方禁用链接
					if(linkData.to.editDisabled){
						return
					}
					if(this._dolink!=null){
						this._dolink(linkData)
					}
				}
			}

			this.__gd.on('mousemove',onMousemoveFun);
			this.__gd.on('mouseup',onMouseupFun);

			document.addEventListener("mouseup", onMouseupFun);
		})
		node.on('mouseover', () => {
			node.attr({
				shape:{
					r:node.shape.r+this.__circleHoverWidth/2
				},
				style:{
					lineWidth:node.style.lineWidth+this.__circleHoverWidth
				}
			})
		})
		node.on('mouseout', ()=>  {
			node.attr({
				shape:{
					r:node.shape.r-this.__circleHoverWidth/2
				},
				style:{
					lineWidth:node.style.lineWidth-this.__circleHoverWidth
				}
			})
		})
	}
	//触发连线过程回调
	_dolink=null;
	_linkEditContain(x,y){
		var  contain=false;
		for(let v of this.__boxGraphList){
			if(v.contain(x,y)){
				contain=true;
				break;
			}
		}
		return contain;
	}
	__clear(){
		for(let v of this.__boxGraphList){
			this.__container.remove(v);
		}
		this.__boxGraphList=[];
	}
	/**
	 * @method 销毁自身添加的图形
	 * @param ()
	 * @return
	 * @author DingJianFei
	 * @date 2019/6/4
	 */
	destroy(){
		this.__clear();
		this.__editable.removeAfterUpdate(this.__updateMySelf);
	}
}
