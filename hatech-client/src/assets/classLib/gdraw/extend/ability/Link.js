import Arrow from '../../renderer/graphic/shape/Arrow'
import objUtil from '../../../utilLib/Obj'
import geometryUtil from '../../../utilLib/Geometry'
/**
 * @Author DingJianFei
 * @Date 2019/5/17
 * @Description: 链接两个可链接元素，
 */
export default class extends Arrow {
    constructor(opts={}) {
        var myOpts = {
            linkPointsType: ['intersect','intersect'],
			zlevel: -1
        }
        let from=opts.from,to= opts.to;
        delete opts.from;
		delete opts.to;
        objUtil.deepMix(myOpts, opts);
        super(myOpts);
        this.from=from;
		this.to=to;
		if(this.from&&this.to){
			//为两边节点注册link
			this.from.registerLink(this);
			this.to.registerLink(this);
		}
    }
	type='link';
    /**
     * @attr 覆盖父类属性，连线不可以被连线
     * @author DingJianFei
     * @date 2019/6/21
     */
	isLinkable=false;
    /**
     * @Author DingJianFei
     * @Date 2019/5/26
     * @Description:  //连线需要被连接的物体以及放置连线的盒子已渲染，才可以正确计算关系完成渲染
    */


	isEditable=true;

	editType='link';

	getEditPosition(){
		let points=[];
		if(this.shape.breakPoints){
			for(let v of this.shape.breakPoints){
				points.push(this.transformCoordToGlobal(v[0],v[1]));
			}
		}
		points.unshift(this.transformCoordToGlobal(this.shape.x1,this.shape.y1));
		points.push(this.transformCoordToGlobal(this.shape.x2,this.shape.y2));

		return points;
	}

	changeEditAttr(arr){
		let absolutePoints=arr.slice(1,arr.length-1);
		let points=[];
		for(let v of absolutePoints){
			points.push(this.transformCoordToLocal(v[0],v[1]));
		}
		this.attr({
			shape:{
				breakPoints:points
			}
		})
	}

	_delayUpdate(){

		let isInit=this._isInit();
		if(!isInit&&this.from.__storage&&this.to.__storage){
			this.__gd._nextRefresh();
		}
		return isInit;
	}
	__firstInit=false;
	//确认计算坐标依赖的元素都已加载，如果都已加载且首次更新，则更新一次位置
	_isInit(){
		if(!this.from||!this.to){
			return true;
		}
		if(this.from.rendered&&this.to.rendered){
			if(this.parent==undefined||this.parent.rendered){
				if(!this.__firstInit){
					this.__firstInit=true;
					this.updateLink();
				}
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	attr(opts){
		if(opts.shape&&this._isInit()){
			if(opts.shape.breakPoints){
				this.shape.breakPoints=opts.shape.breakPoints;
			}
			let shape=this._getArrowShape();
			objUtil.deepMix(opts, {
				shape:shape
			});
		}
		super.attr(opts)
	}
	/**
	 * @method 获取连接的物体数据更新自己
	 * @author DingJianFei
	 * @date 2019/5/24
	 */
    updateLink(){
    	if(!this._isInit()){
    		return;
		}
		var shape=this._getArrowShape();
		super.attr({shape:shape})
	}
	_getArrowShape(){
		var fromPosition=this.from.getLinkAbsolutePosition();
		var toPosition=this.to.getLinkAbsolutePosition();
		var A={
			x:0,
			y:0
		}
		var B={
			x:0,
			y:0
		}
		if(this.linkPointsType[0]=="top"){
			A.x=fromPosition.E[0]
			A.y=fromPosition.E[1]
		}else if(this.linkPointsType[0]=="right"){
			A.x=fromPosition.F[0]
			A.y=fromPosition.F[1]
		}else if(this.linkPointsType[0]=="bottom"){
			A.x=fromPosition.G[0]
			A.y=fromPosition.G[1]
		}else if(this.linkPointsType[0]=="left"){
			A.x=fromPosition.H[0]
			A.y=fromPosition.H[1]
		}

		if(this.linkPointsType[1]=="top"){
			B.x=toPosition.E[0]
			B.y=toPosition.E[1]
		}else if(this.linkPointsType[1]=="right"){
			B.x=toPosition.F[0]
			B.y=toPosition.F[1]
		}else if(this.linkPointsType[1]=="bottom"){
			B.x=toPosition.G[0]
			B.y=toPosition.G[1]
		}else if(this.linkPointsType[1]=="left"){
			B.x=toPosition.H[0]
			B.y=toPosition.H[1]
		}

		//交点的情况
		var intersectFrom=null,intersectTo=null;
		if(this.linkPointsType[0]=="intersect"){
			let fromXY=[fromPosition.center[0],fromPosition.center[1]], toXY=[];
			if(this.shape.breakPoints&&this.shape.breakPoints.length>0){
				let myToXy=this.shape.breakPoints[0];
				if(this.transform){
					toXY=this.parent.transformCoordToGlobal(myToXy[0],myToXy[1]);
				}else if(this.parent){
					toXY=this.parent.transformCoordToGlobal(myToXy[0],myToXy[1]);
				}else{
					toXY=myToXy;
				}
			}else{
				if(this.linkPointsType[1]!="intersect"){
					toXY=[B.x,B.y]
				}else{
					toXY=[toPosition.center[0],toPosition.center[1]]
				}
			}

			intersectFrom=getIntersect(fromXY,toXY,fromPosition);
		}

		if(this.linkPointsType[1]=="intersect"){
			let fromXY=[], toXY=[toPosition.center[0],toPosition.center[1]]

			if(this.shape.breakPoints&&this.shape.breakPoints.length>0){
				let myFromXY=this.shape.breakPoints[this.shape.breakPoints.length-1];
				if(this.transform){
					fromXY=this.parent.transformCoordToGlobal(myFromXY[0],myFromXY[1]);
				}else if(this.parent){
					fromXY=this.parent.transformCoordToGlobal(myFromXY[0],myFromXY[1]);
				}else{
					fromXY=myFromXY;
				}
			}else{
				if(this.linkPointsType[0]!="intersect"){
					fromXY=[A.x,A.y]
				}else{
					fromXY=[fromPosition.center[0],fromPosition.center[1]]
				}
			}

			intersectTo=getIntersect(fromXY,toXY,toPosition);
		}
		if(intersectFrom!=null){
			A.x=intersectFrom.x
			A.y=intersectFrom.y
		}
		if(intersectTo!=null){
			B.x=intersectTo.x
			B.y=intersectTo.y
		}


		let shape={
			x1:A.x,
			y1:A.y,
			x2:B.x,
			y2:B.y
		}
		if(this.parent){
			let start=this.parent.transformCoordToLocal(shape.x1,shape.y1);
			let end=this.parent.transformCoordToLocal(shape.x2,shape.y2);
			shape={
				x1:start[0],
				y1:start[1],
				x2:end[0],
				y2:end[1]
			}
		}
		return shape
	}
}

//线段与矩形交点
function getIntersect(fromXY, toXY, boxData) {
    var intersect = null;
    //正方形四条边
    var edgeArr = [
        {
            x1: boxData.A[0],
            y1: boxData.A[1],
            x2: boxData.B[0],
            y2: boxData.B[1]
        },
        {
            x1: boxData.B[0],
            y1: boxData.B[1],
            x2: boxData.C[0],
            y2: boxData.C[1],
        },
        {
			x1: boxData.C[0],
			y1: boxData.C[1],
			x2: boxData.D[0],
			y2: boxData.D[1],
        },
        {
			x1: boxData.D[0],
			y1: boxData.D[1],
			x2: boxData.A[0],
			y2: boxData.A[1],
        },
    ]
    //与矩形存在交点则返回交点
    for (let v of edgeArr) {
        var intersection = geometryUtil.lineSegmentIntersection({
            x: fromXY[0], y: fromXY[1]
        }, {
            x: toXY[0], y: toXY[1]
        }, {
            x: v.x1, y: v.y1
        }, {
            x: v.x2, y: v.y2
        })
        if (intersection != false) {
			intersect = {
				x: intersection.x,
				y: intersection.y
            };
            break;
        }
    }
    //没有交点说明在矩形内部返回中心点
    if (intersect == null) {
		intersect = {
			x: boxData.center[0],
			y: boxData.center[1]
		};
    }
    return intersect;
}
