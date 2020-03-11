/**
 * @Author DingJianFei
 * @Date 2018/4/4
 * @Description: Dom操作相关方法
 */
export default{
	/**
	 * @method 禁止canvas右键，监听窗口变化，根据canvas父级尺寸，控制canvas大小
	 * @param (Gdraw)
	 * @return
	 * @author DingJianFei
	 * @date 2019/5/28
	 */
	drawSizeCon:function (gds) {
		for(let gd of gds){
			gd.dom.oncontextmenu = function (event) {
				return false;
			};
		}
		window.onresize = function () {
			updateCanvasSize(gds)
		}
	}
}
function updateCanvasSize(gds) {
	for(let gd of gds){
		let width=gd.dom.clientWidth,height=gd.dom.clientHeight;
		gd.dom.width = width;
		gd.dom.height = height;
		gd.resize({
			width: width,
			height: height
		});
	}
}
