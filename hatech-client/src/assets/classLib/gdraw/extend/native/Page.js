import Group from "../../renderer/container/Group";
import objUtil from '../../../utilLib/Obj'
/**
 * @Author DingJianFei
 * @Date 2019/5/27
 * @Description: 一个页面
*/
export default class extends  Group{
	constructor(opts={}){
		var myOpts = {
			dragPage:false,//页面拖拽
			zoom:false,//每次滚轮页面缩放比率，不赋值不开启缩放功能
			zoomType:'center'//缩放类型，center中心缩放，pointer跟随鼠标指针位置。
		}
		objUtil.deepMix(myOpts, opts);
		super(opts);
	}
	type='page';
	/**
	 * @method 按下画布空白部分时调用的方法控制page拖动
	 * @author DingJianFei
	 * @date 2019/5/30
	 */
	_dragPage(e){
		if(!this.dragPage){
			return;
		}
		let nowPosition=this.position;
		let startX=nowPosition[0],startY=nowPosition[1];
		let onMousemoveFun=(ee) => {
			let offsetX=ee.offsetX-e.offsetX,offsetY=ee.offsetY-e.offsetY;
			this.attr({
				position:[startX+offsetX,startY+offsetY]
			})
		}
		let onMouseupFun=() => {
			this.__gd.off('mousemove',onMousemoveFun);
			document.removeEventListener("mouseup", onMouseupFun)
		}
		this.__gd.on('mousemove',onMousemoveFun);
		document.addEventListener("mouseup", onMouseupFun);
	}
	/**
	 * @method 画布接到滚轮事件时通知页面更新调用的方法
	 * @author DingJianFei
	 * @date 2019/5/30
	 */
	_zoomPage(e){
		if(typeof this.zoom!="number"){
			return;
		}
		let ev=e.event;
		ev.preventDefault();//禁止浏览器动作
		var referenceX=0,referenceY=0;
		//跟随指针中心或者canvas中心
		if(this.zoomType=='pointer'){
			referenceX=e.offsetX;
			referenceY=e.offsetY;
		}else if(this.zoomType=='center'){
			referenceX=this.__gd.dom.clientWidth/2;
			referenceY=this.__gd.dom.clientHeight/2;
		}
		var nowScale = this.scale;
		var scaleX = nowScale[0] + this.zoom * ev.zrDelta,
			scaleY = nowScale[1] + this.zoom * ev.zrDelta,
			positionX=this.position[0],
			positionY=this.position[1];

		//比率缩小到小于0不再缩小
		if(scaleX > 0){
			positionX=positionX-(referenceX-this.position[0])*((this.zoom*ev.zrDelta+nowScale[0])/nowScale[0]-1);
			//小数相加精确度问题
			nowScale[0] = Number(scaleX.toFixed(2));
		}
		if(scaleY > 0){
			positionY=positionY-(referenceY-this.position[1])*((this.zoom*ev.zrDelta+nowScale[1])/nowScale[1]-1);
			nowScale[1] = Number(scaleY.toFixed(2));
		}
		this.attr({
			scale:nowScale,
			position:[positionX,positionY]
		})

    //添加对文字的缩放效果
		let pageChildren = this._children[0]._children; //获取页面上的元素
    for (let element of pageChildren) {
      let style = element.style;
      if (!style.originFontSize) { //保存元素原有的fontSize
        style.originFontSize = style.fontSize;
      }
      style.fontSize = style.originFontSize * nowScale[0];
      element.attr({
        style:style
      });
    }
	}
	/**
	 * @method 重写父级方法，page更新会引起元素来更新相关连线，无需自己更新
	 * @author DingJianFei
	 * @date 2019/5/29
	 */
	notifyLink(){

	}
}
