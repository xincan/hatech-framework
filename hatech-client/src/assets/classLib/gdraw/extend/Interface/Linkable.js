/**
 * @Author DingJianFei
 * @Date 2019/5/17
 * @Description: 可链接元素，Link的观察目标
 */

export default class {
	/**
	 * @attribute 表示自身是否可以被链接，Boolean
	 * @author DingJianFei
	 * @date 2019/5/17
	 */
	isLinkable;
	/**
	 * @method 返回所有被注册的link
	 * @author DingJianFei
	 * @date 2019/6/10
	 */
	getLinkList(){

	}
	/**
	 * @method 注册一个观察者Link
	 * @param (Link)
	 * @return
	 * @author DingJianFei
	 * @date 2019/5/17
	 */
	registerLink(Link) {

	}

	/**
	 * @method 移除一个观察者Link
	 * @param (Link)
	 * @return
	 * @author DingJianFei
	 * @date 2019/5/17
	 */
	removeLink(Link) {

	}

	/**
	 * @method 通知link已经自身已经更新，需要link重新绘制(包括首次)
	 * @param (Link)
	 * @return
	 * @author DingJianFei
	 * @date 2019/5/17
	 */
	notifyLink() {

	}

	/**
	 * @method 返回代表该元素位置的矩形四个点坐标ABCD,矩形四条边中点的EFGH,以及中心点的坐标center
	 * @param ()
	 * @return {A,B,C,D,E,F,G,H,center}  A:[x,y]
	 * @author DingJianFei
	 * @date 2019/5/17
	 */
	getLinkAbsolutePosition() {

	}
}
