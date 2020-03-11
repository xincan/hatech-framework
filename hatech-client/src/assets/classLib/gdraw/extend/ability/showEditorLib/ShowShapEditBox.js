/**
 * @Author dingjianfei
 * @Date 2019/6/4
 * @Description: 为Editable添加一个编辑框用来编辑Editable的大小
 */
import Circle from '../../../renderer/graphic/shape/Circle'
import Line from '../../../renderer/graphic/shape/Line'
import Polygon from '../../../renderer/graphic/shape/Polygon'
import objUtil from '../../../../utilLib/Obj'
export default class {
    constructor(editable,container,opts) {
		this.__editable=editable;
		this.__gd=container.__gd?container.__gd:container;
		this.__opts=opts;
		this.__container=container;
		this.__zlevel=editable.zlevel+1;
		this.__addEditGraph();
		this.__updateMySelf=()=>{
			this.__clear();
			this.__addEditGraph();
		}
		editable.addAfterUpdate(this.__updateMySelf)
    }
    __updateMySelf=null;

    __editGraphList=[];//添加的图形

	__nowEditLinkData=[];
	//添加编辑显示图形
	__addEditGraph(){
		if(this.__editable.editType=='link'){
			this.__addLineGraph()
		}else{
			this.__addBoxGraph()
		}
	}
	//添加线编辑
	__addLineGraph(){
		var absoluteEp=this.__editable.getEditPosition();
		var ep=[];
		if(this.__container.transformCoordToLocal){
			for(let v of absoluteEp){
				ep.push(this.__container.transformCoordToLocal(v[0],v[1]));
			}
		}else{
			ep=absoluteEp;
		}
		for(let i=0;i<ep.length;i++){
			if(i!=ep.length-1){
				let line=new Line({
					shape:{
						x1:ep[i][0],
						y1:ep[i][1],
						x2:ep[i+1][0],
						y2:ep[i+1][1],
					},
					zlevel:this.__editable.zlevel+1
				})
				this.__add(line);
				objUtil.deepMix(line,this.__opts.line)
				line.__editIndex=i+1;
				this.__addLineEditEvent(line,ep);
				if(i!=0){
					let cricle=new Circle({
						shape:{
							cx:ep[i][0],
							cy:ep[i][1]
						},
						cursor:'crosshair',
						zlevel: this.__zlevel
					});
					objUtil.deepMix(cricle,this.__opts.circle)
					cricle.__editIndex=i;
					this.__add(cricle);
					this.__addCirleEditEvent(cricle,ep);
				}
			}
		}

	}
	//低概率未知情况下，鼠标抬起mouseup的同时会触发鼠标双击事件，通过该变量控制其不生效
	__restoreBUG=false;
	//给虚拟线增加控制事件
	__addLineEditEvent(line){
		if(this.__editable.editDisabled){
			return;
		}
		var ep=[]
		line.on('mousedown',(e)=>{
			ep=this.__editable.getEditPosition();
			this.__gd.on('mousemove',onMousemoveFun);
			document.addEventListener("mouseup", onMouseupFun);
		})
		let onMousemoveFun=(e) => {
			let points=ep.concat();
			points.splice(line.__editIndex, 0,[e.offsetX,e.offsetY]);
			this.__editable.changeEditAttr(points);
		}
		let onMouseupFun=(e) => {
			this.__gd.off('mousemove',onMousemoveFun);
			document.removeEventListener("mouseup", onMouseupFun);
			this.__restoreBUG=true;
			setTimeout( () => {
				this.__restoreBUG=false;
			},100)
		}
	}

	__addCirleEditEvent(cricle){
		if(this.__editable.editDisabled){
			return;
		}
		var ep=[]
		cricle.on('mousedown',(e)=>{
			ep=this.__editable.getEditPosition();
			this.__gd.on('mousemove',onMousemoveFun);
			document.addEventListener("mouseup", onMouseupFun);
		})
		let onMousemoveFun=(e) => {
			let points=ep.concat();
			points[cricle.__editIndex]=[e.offsetX,e.offsetY];
			this.__editable.changeEditAttr(points);
		}
		let onMouseupFun=(e) => {
			this.__gd.off('mousemove',onMousemoveFun);
			document.removeEventListener("mouseup", onMouseupFun)
		}

		cricle.on('dblclick',(e)=>{
			if(this.__restoreBUG){
				return;
			}
			let points=ep.concat();
			points.splice(cricle.__editIndex,1)
			this.__editable.changeEditAttr(points);
		})
	}
	//添加盒子编辑
	__addBoxGraph(){
		var ep=this.__editable.getEditPosition();
		var points=this.__editable.getShapeEditPoints();
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
		var rectBox=new Polygon({
			shape:{
				points:[[ep.A[0],ep.A[1]],[ep.B[0],ep.B[1]],[ep.C[0],ep.C[1]],[ep.D[0],ep.D[1]],]
			},
			zlevel: this.__zlevel
		});
		objUtil.deepMix(rectBox,this.__opts.rect)
		this.__add(rectBox,ep)

	}
	//添加自身需要生成的图形
	__add(graph){
		graph.unEdit=true;
		graph.isEditDisplay=true;
		this.__container.add(graph);
		this.__editGraphList.push(graph);
	}
	//为控制点增加事件
	__addNodeDragEvent(node,fun){
		if(this.__editable.editDisabled){
			return;
		}
		var oldX=0,oldY=0;
		node.on('mousedown',(e)=>{
			oldX=e.offsetX;oldY=e.offsetY;
			this.__gd.on('mousemove',onMousemoveFun);
			document.addEventListener("mouseup", onMouseupFun);
		})
		let onMousemoveFun=(e) => {
			let moveX=e.offsetX-oldX,moveY=e.offsetY-oldY;
			fun(moveX,moveY);
			oldX=e.offsetX,oldY=e.offsetY;
		}
		let onMouseupFun=(e) => {
			this.__gd.off('mousemove',onMousemoveFun);
			document.removeEventListener("mouseup", onMouseupFun)
		}
	}
	//改变控制的图形
	__changeEditable(attr){
		this.__editable.changeEditAttr(attr);
	}
	__clear(){
		for(let v of this.__editGraphList){
			this.__container.remove(v);
		}
		this.__editGraphList=[];
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
