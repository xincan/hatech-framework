//                                                _ooOoo_
//                                               o8888888o
//                                               88" . "88
//                                               (| -_- |)
//                                                O\ = /O
//                                            ____/`---'\____
//                                          .   ' \\| |// `.
//                                           / \\||| : |||// \
//                                         / _||||| -:- |||||- \
//                                           | | \\\ - /// | |
//                                         | \_| ''\---/'' | |
//                                          \ .-\__ `-` ___/-. /
//                                       ___`. .' /--.--\ `. . __
//                                    ."" '< `.___\_<|>_/___.' >'"".
//                                   | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                                     \ \ `-. \_ __\ /__ _/ .-` / /
//                             ======`-.____`-.___\_____/___.-`____.-'======
//                                                `=---='
//
//                             .............................................
//                                    佛祖保佑             永无BUG

import PageAdmin from './extend/native/PageAdmin';
import bomUtil from '../utilLib/Bom'
import guid from './renderer/core/guid';
import env from './renderer/core/env';
import Handler from './renderer/Handler';
import Storage from './renderer/Storage';
import Painter from './renderer/Painter';
import Animation from './renderer/animation/Animation';
import HandlerProxy from './renderer/dom/HandlerProxy';
import * as myLib from './export';
//svg、vml渲染
import './renderer/svg/graphic';
import svgPainter from './renderer/svg/Painter';
import './renderer/vml/graphic';
import vmlPainter from './renderer/vml/Painter';

var useVML = !env.canvasSupported;
var painterCtors = {
	canvas: Painter,
	svg: svgPainter,
	vml: vmlPainter
};
//实例集合
var instances = {};
export default class {
	//版本号
	static version = '1.0.1';
	constructor(dom, opts) {
		this.__initZr(dom, opts);
		this.pageAdmin=new PageAdmin(this);
		this.on("mousedown", (e) => {
			if(e.which==3){
				let page=this.pageAdmin.getNowPage();
				if(!page){
					return;
				}
				page._dragPage(e);
			}

		})
		//监听画布滚轮，若页面存在，通知页面缩放
		this.on('mousewheel',(e) => {
			var page=this.pageAdmin.getNowPage();
			if(!page){
				return;
			}
			page._zoomPage(e);
		})
	}



	/*扩展*/

	_needsNextRefresh=false;
	/**
	 * @method 返回canvas图形的dataURL
	 * @param ({type,backgroundColor,format})
		 * type: all||window,全部图形（包括超出边界看不见的）还是仅当前窗口内可见的。
		 * backgroundColor:String,设置背景颜色
		 * format:String,图片格式
	 * @return  DataURL
	 * @author DingJianFei
	 * @date 2019/5/30
	 */
	getDataURL({type="all",format="png",backgroundColor}){
		var dataUrl=null,nowPage=this.pageAdmin.getNowPage();
		if(type=="window"||nowPage==undefined){
			//复制一个加背景的层导出
			dataUrl=this.painter.getRenderedCanvas({
				backgroundColor: backgroundColor
			}).toDataURL("image/"+format);
		}else if(type=="all"){
			//保存原有数据
			var oldWidth=this.dom.offsetWidth,
			 	oldHeight=this.dom.offsetHeight,
				oldStyleWidth=this.dom.style.width,
				oldStyleHeight=this.dom.style.height,
			 	oldScaleX=nowPage.scale[0],
			 	oldScaleY=nowPage.scale[1],
			 	oldPosition={
					x:nowPage.position[0],
					y:nowPage.position[1]
				}
			var nowPageRect=nowPage.getBoundingRect();
			//修改容器状态放大Dom,加的值是为了给图片边上留白
			this.dom.style.overflow='hidden'
			this.dom.style.visibility="hidden";
			var addWidth=400,addHeight=100;
			this.dom.style.width=nowPageRect.width+addWidth+'px';
			this.dom.style.height=nowPageRect.height+addHeight+'px';
			this.resize({
				width:nowPageRect.width+addWidth,
				height:nowPageRect.height+addHeight
			});
			nowPage.attr({
				position:[-nowPageRect.x+addWidth/2,-nowPageRect.y+addHeight/2],
				scale:[1,1]
			})

			dataUrl=this.painter.getRenderedCanvas({
				backgroundColor: backgroundColor
			}).toDataURL("image/"+format);

			//还原
			this.dom.style.width=oldStyleWidth;
			this.dom.style.height=oldStyleHeight;
			this.resize({
				width:oldWidth,
				height:oldHeight
			});
			nowPage.attr({
				position:[oldPosition.x,oldPosition.y],
				scale:[oldScaleX,oldScaleY]
			})
			this.dom.style.visibility="visible";
			this.dom.style.overflow='visible';
		}
		return dataUrl;
	}
	/**
	 * @method 下载canvas图形为图片（火狐、谷歌、IE）
	 * @param ({type,backgroundColor,format,name})
		 * type: all||window,全部图形（包括超出边界看不见的）还是仅当前窗口内可见的。
		 * backgroundColor:String,设置背景颜色
		 * format:String,图片格式
		 * name:String,文件名（后缀需要与format的类型一致）
	 * @author DingJianFei
	 * @date 2019/5/30
	 */
	savePicture({type="all",backgroundColor,name="",format="png"}){
		bomUtil.saveImageFromBase64(this.getDataURL({type,backgroundColor,format}),name+"."+format);
	}

	/**
	 * @method 根据id查询元素
	 * @param (id)
	 * @return  element
	 * @author DingJianFei
	 * @date 2019/6/26
	 */
	find(id){
		if(!id){
			return null;
		}
		function findEl(list) {
			for(let v of list){
				if(v.isGroup){
					return findEl(v.children())
				}else{
					if(v.id==id){
						return v;
					}
				}
			}
		}
		return findEl(this.storage._roots);
	}



	/*原有功能*/
	static dispose(zr) {
		if (zr) {
			zr.dispose();
		}
		else {
			for (var key in instances) {
				if (instances.hasOwnProperty(key)) {
					instances[key].dispose();
				}
			}
			instances = {};
		}

		return this;
	}

	static getInstance(id) {
		return instances[id];
	}

	static delInstance(id) {
		delete instances[id];
	}
	__initZr(dom, opts){
		var id = guid();
		instances[id] = this;
		opts = opts || {};
		this.dom = dom;
		this.id = id;
		var self = this;
		var storage = new Storage();
		var rendererType = opts.renderer;
		if (useVML) {
			if (!painterCtors.vml) {
				throw new Error('You need to require \'zrender/vml/vml\' to support IE8');
			}
			rendererType = 'vml';
		}
		else if (!rendererType || !painterCtors[rendererType]) {
			rendererType = 'canvas';
		}
		var painter = new painterCtors[rendererType](dom, storage, opts, id);

		this.storage = storage;
		this.painter = painter;
		var handerProxy = (!env.node && !env.worker) ? new HandlerProxy(painter.getViewportRoot()) : null;
		this.handler = new Handler(storage, painter, handerProxy, painter.root);
		this.animation = new Animation({
			stage: {
				update: myLib.util.bind(this.flush, this)
			}
		});
		this.animation.start();
		this._needsRefresh;
		var oldDelFromStorage = storage.delFromStorage;
		var oldAddToStorage = storage.addToStorage;
		storage.delFromStorage = function (el) {
			oldDelFromStorage.call(storage, el);
			el && el.removeSelfFromZr(self);
		};
		storage.addToStorage = function (el) {
			oldAddToStorage.call(storage, el);
			el.addSelfToZr(self);
		};
	}
	getId() {
		return this.id;
	}

	add(el) {
		el.__gd=this;
		this.storage.addRoot(el);
		this._needsRefresh = true;
	}

	remove(el) {
		this.storage.delRoot(el);

		this._needsRefresh = true;
	}

	configLayer(zLevel, config) {
		if (this.painter.configLayer) {
			this.painter.configLayer(zLevel, config);
		}
		this._needsRefresh = true;
	}

	setBackgroundColor(backgroundColor) {
		if (this.painter.setBackgroundColor) {
			this.painter.setBackgroundColor(backgroundColor);
		}
		this._needsRefresh = true;
	}

	refreshImmediately() {
		this._needsRefresh = this._needsRefreshHover = this._needsNextRefresh = false;
		this.painter.refresh();
		this._needsRefresh = this._needsRefreshHover = false;
	}

	refresh() {
		this._needsRefresh = true;
	}
	/**
	 * @Author DingJianFei
	 * @Date 2019/5/29
	 * @Description: 某些元素在渲染时需要本帧不渲染的，可以调用在下一帧渲染
	*/
	_nextRefresh(){
		this._needsNextRefresh = true;
	}

	flush() {
		var triggerRendered;
		if (this._needsRefresh||this._needsNextRefresh) {
			triggerRendered = true;
			this.refreshImmediately();
		}
		if (this._needsRefreshHover) {
			triggerRendered = true;
			this.refreshHoverImmediately();
		}

		triggerRendered && this.trigger('rendered');
	}

	addHover(el, style) {
		if (this.painter.addHover) {
			var elMirror = this.painter.addHover(el, style);
			this.refreshHover();
			return elMirror;
		}
	}

	removeHover(el) {
		if (this.painter.removeHover) {
			this.painter.removeHover(el);
			this.refreshHover();
		}
	}

	clearHover() {
		if (this.painter.clearHover) {
			this.painter.clearHover();
			this.refreshHover();
		}
	}

	refreshHover() {
		this._needsRefreshHover = true;
	}

	refreshHoverImmediately() {
		this._needsRefreshHover = false;
		this.painter.refreshHover && this.painter.refreshHover();
	}

	resize(opts) {
		opts = opts || {};
		this.painter.resize(opts.width, opts.height);
		this.handler.resize();
	}

	clearAnimation() {
		this.animation.clear();
	}

	getWidth() {
		return this.painter.getWidth();
	}

	getHeight() {
		return this.painter.getHeight();
	}

	pathToImage(e, dpr) {
		return this.painter.pathToImage(e, dpr);
	}

	setCursorStyle(cursorStyle) {
		this.handler.setCursorStyle(cursorStyle);
	}

	findHover(x, y) {
		return this.handler.findHover(x, y);
	}

	on(eventName, eventHandler, context) {
		this.handler.on(eventName, eventHandler, context);
	}

	off(eventName, eventHandler) {
		this.handler.off(eventName, eventHandler);
	}

	trigger(eventName, event) {
		this.handler.trigger(eventName, event);
	}

	clear() {
		this.storage.delRoot();
		this.painter.clear();
	}

	dispose() {
		this.animation.stop();

		this.clear();
		this.storage.dispose();
		this.painter.dispose();
		this.handler.dispose();
		this.animation =
			this.storage =
				this.painter =
					this.handler = null;

		delInstance(this.id);
	}


	//列举功能类出来方便idea工具检查提示
	static util = myLib.util
	static Arc = myLib.Arc
	static BezierCurve = myLib.BezierCurve
	static BoundingRect = myLib.BoundingRect
	static Circle = myLib.Circle
	static color = myLib.color
	static CompoundPath = myLib.CompoundPath
	static Droplet = myLib.Droplet
	static Ellipse = myLib.Ellipse
	static Group = myLib.Group
	static Heart = myLib.Heart
	static Image = myLib.Image
	static IncrementalDisplayable = myLib.IncrementalDisplayable
	static Isogon = myLib.Isogon
	static Line = myLib.Line
	static LinearGradient = myLib.LinearGradient
	static matrix = myLib.matrix
	static parseSVG = myLib.parseSVG
	static Path = myLib.Path
	static Pattern = myLib.Pattern
	static Polygon = myLib.Polygon
	static Polyline = myLib.Polyline
	static RadialGradient = myLib.RadialGradient
	static Ring = myLib.Ring
	static Rose = myLib.Rose
	static Sector = myLib.Sector
	static Star = myLib.Star
	static Rect = myLib.Rect
	static Text = myLib.Text
	static Trochoid = myLib.Trochoid
	static vector = myLib.vector
	static Arrow = myLib.Arrow
	static Link = myLib.Link
	static Editor=myLib.Editor
	static ShowEditor=myLib.ShowEditor
}
