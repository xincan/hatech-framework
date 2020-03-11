/**
 * @Author DingJianFei
 * @Date 2019/5/27
 * @Description: 页面管理员，管理页面
 */
import Page from "./Page";
export default class {
	constructor(gd) {
		this._gd = gd;
	}

	_pageList = [];
	_nowPage = -1;
	//返回所有页面
	getPageList() {
		return this._pageList;
	}
	//隐藏当前页面
	_hideNowPage() {
		if (this._nowPage >= 0) {
			this._pageList[this._nowPage].hide();
		}
	}

	//返回当前显示的页面
	getNowPage() {
		return this._pageList[this._nowPage];
	}

	//关闭一个页面
	close(id) {
		var page = null;
		for (let v of this._pageList) {
			if (v.id == id) {
				page = v;
				break;
			}
		}
		//移除图形
		this._gd.remove(page());
		//修正当前页码
		var pageIndex = arrayUtil.getIndex(page, this._pageList);
		if (this._nowPage >= pageIndex) {
			this._nowPage--;
		}
		//移出队列
		arrayUtil.removeByValue(this._pageList, page)
	}

	//打开一个页面
	open(opts, cover = false) {
		//隐藏当前页面，
		this._hideNowPage();
		//移除被覆盖的历史页面
		for (var i = this._nowPage + 1; i < this._pageList.length; i++) {
			this._gd.remove(this._pageList[i])
		}
		this._pageList.splice(this._nowPage + 1, this._pageList.length)
		//添加新页面
		var page = new Page(opts);
		if (cover&&this.getNowPage()) {
			this._pageList.splice(this._pageList.length - 1, this._pageList.length);
			this._gd.remove(this.getNowPage())
		}
		this._pageList.push(page);
		//修正当前页数
		this._nowPage = this._pageList.length - 1;
		//渲染页面
		this._gd.add(page)
		return page;
	}

	//前往某页面
	go(id) {
		for (let v of this._pageList) {
			if (v.id == id) {
				this._hideNowPage();
				v().show();
				break;
			}
		}
	}

	//返回上一页
	back() {
		if (this._nowPage > 0) {
			this._hideNowPage();
			this._pageList[this._nowPage - 1].show();
			this._nowPage = this._nowPage - 1;
		}
		return this._nowPage;
	}

	//前往下一页
	forward() {
		if (this._nowPage < (this._pageList.length - 1)) {
			this._hideNowPage();
			this._pageList[this._nowPage + 1].show();
			this._nowPage = this._nowPage + 1;
		}
		return this._nowPage;
	}
}
