/**
 * 可绘制的图形(抽象类)
 * Base class of all displayable graphic objects
 * @module zrender/graphic/Displayable
 */


import * as zrUtil from '../core/util';
import Style from './Style';
import Element from '../Element';
import RectText from './mixin/RectText';
import arrayUtil from '../../../utilLib/Array'
import jsonUtil from '../../../utilLib/Json'
/**
 * @alias module:zrender/graphic/Displayable
 * @extends module:zrender/Element
 * @extends module:zrender/graphic/mixin/RectText
 * @implements src/assets/classLib/gdraw/extend/Interface/Linkable
 * @implements src/assets/classLib/gdraw/extend/Interface/Editable（未实现所有方法）
 */
function Displayable(opts) {

    opts = opts || {};

    Element.call(this, opts);

    // Extend properties
    for (var name in opts) {
        if (
            opts.hasOwnProperty(name)
                && name !== 'style'
        ) {
            this[name] = opts[name];
        }
    }

    /**
     * @type {module:zrender/graphic/Style}
     */
    this.style = new Style(opts.style, this);

    this._rect = null;
    // Shapes for cascade clipping.
    // Can only be `null`/`undefined` or an non-empty array, MUST NOT be an empty array.
    // because it is easy to only using null to check whether clipPaths changed.
    this.__clipPaths = null;

    // FIXME Stateful must be mixined after style is setted
    // Stateful.call(this, opts);

	//更新后通知link
	this.addAfterUpdate(function () {
		this.notifyLink();
	})

	//连线集合
	this._linklist=[];
}

Displayable.prototype = {
    constructor: Displayable,

    type: 'displayable',



	/**
	 * @Author DingJianFei
	 * @Date 2019/5/26
	 * @Description: 实现Linkable接口
	*/
	isLinkable:true,
	registerLink:function(Link) {
		this._linklist.push(Link);
	},
	getLinkList:function(){
		return this._linklist;
	},
	removeLink:function(Link) {
		if(Link==undefined){
			this._linklist=[];
		}else{
			arrayUtil.removeByValue(this._linklist,Link)
		}

	},
	notifyLink:function() {
		for(let v of this._linklist){
			v.updateLink();
		}
	},
	getLinkAbsolutePosition:function() {
		var box =jsonUtil.copy(this.getBoundingRect())
		//返回盒子适当扩大
		var addNum = 2;
		box.x = box.x - addNum;
		box.y = box.y - addNum;
		box.width = box.width + addNum * 2;
		box.height = box.height + addNum * 2;
		var A = [box.x,box.y],
			B = [box.x+box.width,box.y],
			C = [box.x+box.width,box.y+box.height],
			D = [box.x,box.y+box.height],
			E = [box.x+box.width/2,box.y],
			F = [box.x+box.width,box.y+box.height/2],
			G = [box.x+box.width/2,box.y+box.height],
			H = [box.x,box.y+box.height/2],
			center = [box.x+box.width/2,box.y+box.height/2];
		return  {
			A: this.transformCoordToGlobal(A[0],A[1]),
			B: this.transformCoordToGlobal(B[0],B[1]),
			C: this.transformCoordToGlobal(C[0],C[1]),
			D: this.transformCoordToGlobal(D[0],D[1]),
			E: this.transformCoordToGlobal(E[0],E[1]),
			F: this.transformCoordToGlobal(F[0],F[1]),
			G: this.transformCoordToGlobal(G[0],G[1]),
			H: this.transformCoordToGlobal(H[0],H[1]),
			center: this.transformCoordToGlobal(center[0],center[1])
		}
	},





	/**
	 * @Author DingJianFei
	 * @Date 2019/6/4
	 * @Description: 实现Editable接口部分方法/属性
	 */
	editType:'size',
	getEditPosition:function(){
		var box =jsonUtil.copy(this.getBoundingRect())
		var reduce=Math.ceil(this.style.lineWidth/2)-1
		if(reduce>0){
			box.x=box.x+reduce;box.y=box.y+reduce;box.width=box.width-reduce*2;box.height=box.height-reduce*2;
		}
		var A = [box.x,box.y],
			B = [box.x+box.width,box.y],
			C = [box.x+box.width,box.y+box.height],
			D = [box.x,box.y+box.height],
			E = [box.x+box.width/2,box.y],
			F = [box.x+box.width,box.y+box.height/2],
			G = [box.x+box.width/2,box.y+box.height],
			H = [box.x,box.y+box.height/2],
			center = [box.x+box.width/2,box.y+box.height/2];
		return  {
			A: this.transformCoordToGlobal(A[0],A[1]),
			B: this.transformCoordToGlobal(B[0],B[1]),
			C: this.transformCoordToGlobal(C[0],C[1]),
			D: this.transformCoordToGlobal(D[0],D[1]),
			E: this.transformCoordToGlobal(E[0],E[1]),
			F: this.transformCoordToGlobal(F[0],F[1]),
			G: this.transformCoordToGlobal(G[0],G[1]),
			H: this.transformCoordToGlobal(H[0],H[1]),
			center: this.transformCoordToGlobal(center[0],center[1])
		}
	},
	getShapeEditPoints(){
		return this.shapeEditPoints.slice(0);
	},
	//形状编辑点
	shapeEditPoints:['A','B','C','D','E','F','G','H'],

    /**
     * Displayable 是否为脏，Painter 中会根据该标记判断是否需要是否需要重新绘制
     * Dirty flag. From which painter will determine if this displayable object needs brush
     * @name module:zrender/graphic/Displayable#__dirty
     * @type {boolean}
     */
    __dirty: true,

    /**
     * 图形是否可见，为true时不绘制图形，但是仍能触发鼠标事件
     * If ignore drawing of the displayable object. Mouse event will still be triggered
     * @name module:/zrender/graphic/Displayable#invisible
     * @type {boolean}
     * @default false
     */
    invisible: false,

    /**
     * @name module:/zrender/graphic/Displayable#z
     * @type {number}
     * @default 0
     */
    z: 0,

    /**
     * @name module:/zrender/graphic/Displayable#z
     * @type {number}
     * @default 0
     */
    z2: 0,

    /**
     * z层level，决定绘画在哪层canvas中
     * @name module:/zrender/graphic/Displayable#zlevel
     * @type {number}
     * @default 0
     */
    zlevel: 0,

    /**
     * 是否可拖拽
     * @name module:/zrender/graphic/Displayable#draggable
     * @type {boolean}
     * @default false
     */
    draggable: false,

    /**
     * 是否正在拖拽
     * @name module:/zrender/graphic/Displayable#draggable
     * @type {boolean}
     * @default false
     */
    dragging: false,

    /**
     * 是否相应鼠标事件
     * @name module:/zrender/graphic/Displayable#silent
     * @type {boolean}
     * @default false
     */
    silent: false,

    /**
     * If enable culling
     * @type {boolean}
     * @default false
     */
    culling: false,

    /**
     * Mouse cursor when hovered
     * @name module:/zrender/graphic/Displayable#cursor
     * @type {string}
     */
    cursor: 'pointer',

    /**
     * If hover area is bounding rect
     * @name module:/zrender/graphic/Displayable#rectHover
     * @type {string}
     */
    rectHover: false,

    /**
     * Render the element progressively when the value >= 0,
     * usefull for large data.
     * @type {boolean}
     */
    progressive: false,

    /**
     * @type {boolean}
     */
    incremental: false,
    /**
     * Scale ratio for global scale.
     * @type {boolean}
     */
    globalScaleRatio: 1,

    beforeBrush: function (ctx) {},

    afterBrush: function (ctx) {},

    /**
     * 图形绘制方法
     * @param {CanvasRenderingContext2D} ctx
     */
    // Interface
    brush: function (ctx, prevEl) {},

    /**
     * 获取最小包围盒
     * @return {module:zrender/core/BoundingRect}
     */
    // Interface
    getBoundingRect: function () {},

    /**
     * 判断坐标 x, y 是否在图形上
     * If displayable element contain coord x, y
     * @param  {number} x
     * @param  {number} y
     * @return {boolean}
     */
    contain: function (x, y) {
        return this.rectContain(x, y);
    },

    /**
     * @param  {Function} cb
     * @param  {}   context
     */
    traverse: function (cb, context) {
        cb.call(context, this);
    },

    /**
     * 判断坐标 x, y 是否在图形的包围盒上
     * If bounding rect of element contain coord x, y
     * @param  {number} x
     * @param  {number} y
     * @return {boolean}
     */
    rectContain: function (x, y) {
        var coord = this.transformCoordToLocal(x, y);
        var rect = this.getBoundingRect();
        return rect.contain(coord[0], coord[1]);
    },

    /**
     * 标记图形元素为脏，并且在下一帧重绘
     * Mark displayable element dirty and refresh next frame
     */
    dirty: function () {

        this.__dirty = this.__dirtyText = true;

        this._rect = null;

        this.__gd && this.__gd.refresh();
    },

    /**
     * 图形是否会触发事件
     * If displayable object binded any event
     * @return {boolean}
     */
    // TODO, 通过 bind 绑定的事件
    // isSilent: function () {
    //     return !(
    //         this.hoverable || this.draggable
    //         || this.onmousemove || this.onmouseover || this.onmouseout
    //         || this.onmousedown || this.onmouseup || this.onclick
    //         || this.ondragenter || this.ondragover || this.ondragleave
    //         || this.ondrop
    //     );
    // },
    /**
     * Alias for animate('style')
     * @param {boolean} loop
     */
    animateStyle: function (loop) {
        return this.animate('style', loop);
    },

    attrKV: function (key, value) {
        if (key !== 'style') {
            Element.prototype.attrKV.call(this, key, value);
        }
        else {
            this.style.set(value);
        }
    },

    /**
     * @param {Object|string} key
     * @param {*} value
     */
    setStyle: function (key, value) {
        this.style.set(key, value);
        this.dirty(false);
        return this;
    },

    /**
     * Use given style object
     * @param  {Object} obj
     */
    useStyle: function (obj) {
        this.style = new Style(obj, this);
        this.dirty(false);
        return this;
    }
};

zrUtil.inherits(Displayable, Element);

zrUtil.mixin(Displayable, RectText);
// zrUtil.mixin(Displayable, Stateful);

export default Displayable;
