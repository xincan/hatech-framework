import Group from "../../renderer/container/Group"
import ShapEditBox from './editorLib/ShapEditBox'
import LinkEditBox from './editorLib/LinkEditBox'
import Link from './Link'
import objUtil from '../../../utilLib/Obj'

/**
 * @Author dingjianfei
 * @Date 2019/6/3
 * @Description:编辑器，添加编辑可编辑元素,完成编辑逻辑
 */
export default class extends Group{
    constructor(opts) {
		var myOpts = {
			editorConfig:{
				link:{
					style:{
						stroke:"#000",
						lineWidth:'2'
					}
				},
				selected:{
					circle:{
						shape:{
							r:5
						},
						style:{
							fill:"#007CFC",
							stroke:'#bef8fd',
							lineWidth:1
						}
					},
					rect:{
						style:{
							fill:null,
							stroke:'#00A6FD',
							lineDash:[4,4],
							lineWidth:1
						}
					},
					line:{
						style:{
							stroke:'#00A6FD',
							lineDash:[8,8],
							lineWidth:3
						}
					}
				},
				hover:{
					circle:{
						shape:{
							r:5
						},
						style:{
							fill:"rgba(225,12,127,0.7)",
							stroke:'#9ee7fd',
							lineWidth:1
						}
					},
					rect:{
						style:{
							fill:"rgba(225,225,225,0)",
							stroke:'#00A6FD',
							lineDash:[4,4],
							lineWidth:1
						}
					},
				},

			}
		}
		objUtil.deepMix(myOpts, opts);
		super(myOpts);
		//渲染更新后，未初始化，则初始化向gd注册事件
		this.addAfterUpdate(() => {
			if(!this.__editIsInit){
				//FIXME 编辑器销毁未销毁该事件
				this.__gd.on('click',(e) => {
					if(e.target!=undefined&&e.target.isEditDisplay){
						return;
					}
					if(e.target==undefined||!e.target.isEditable||e.target.unEdit||e.target.unEditShape){
						let oldEl=this.__selectedElement;
						this.__selectedElement=null;
						if(this.__shapEditBox!=null){
							this.__removeShapeEditBox();
						}
						if(oldEl!=null&&this.unselectedAfter){
							this.unselectedAfter(oldEl);
						}
					}
				})
			}
		})
    }
	type='editor';
    //已选中的元素
    __selectedElement=null;

    __editIsInit=false;
    __shapEditBox=null;
    __editEl=null;
    __linkableHoverBox=null;
	__hoverEl=null;
	__indrag=false;
	//重写父类添加方法，
    add(el){
    	//改造要添加的元素，使其具备编辑特性
    	let _this=this;
    	function f(el) {
    		if(el.isGroup){
    			if(!el.editReform){
    				for(let v of el.children()){
						if(v.isGroup){
							f(v);
						}else{
							_this.__reformEl(v);
						}
					}
					el._addBeforeFun=function(eel){
						_this.__reformEl(eel);
					}
				}
    			el.editReform=true;
			}else{
				_this.__reformEl(el);
			}
		}
		f(el);

    	super.add(el);
	}
	__reformEl(el){
		if(el.isEditable&&!el.unEdit){
			el.on('click',(e)=>{
				let oldEl=this.__selectedElement;
				this.__selectedElement=el;

				if(this.selectedAfter){
					this.selectedAfter(el,oldEl);
				};

				if(this.__shapEditBox!=null){
					this.__removeShapeEditBox();
				}
				if(this.__hoverEl!=null&&this.__hoverEl===el){
					this.__removeBinkableHoverBox()
				}
				if(!el.unEditShape){
					this.__shapEditBox=new ShapEditBox(el,this,this.editorConfig.selected);
					this.__editEl=el;
				}

			})
			el.on('mouseover',(e)=>{
				if(this.__editEl===el||this.__indrag){
					return;
				}
				if(this.__linkableHoverBox!=null){
					this.__removeBinkableHoverBox()
				}

				if(!el.unEditLink&&el.isLinkable){
					this.__linkableHoverBox=new LinkEditBox(el,this,this.editorConfig.hover);
					this.__linkableHoverBox._addEvent( (linkEdit)=>  {
						linkEdit.on('mouseout', (e)=>  {
							if(this.__linkableHoverBox._linkEditContain(e.offsetX,e.offsetY)){
								return;
							}
							this.__removeBinkableHoverBox()
						})
					})
					this.__linkableHoverBox._dolink=(linkData)=>{
						let userAttr={};
						if(typeof this.linkbefore=="function"){
							let userReturn=this.linkbefore(linkData);
							if(userReturn==false||userReturn==undefined){
								return;
							}
							if(userReturn&&typeof userReturn=='object'){
								userAttr=userReturn;
							}
						}
						let zlevel=0;
						linkData.from.zlevel>=linkData.to.zlevel?zlevel=linkData.from.zlevel+1:zlevel=linkData.to.zlevel+1
						let linkAttr={
							from:linkData.from,
							to:linkData.to,
							linkPointsType: [linkData.linkPointsType[0],linkData.linkPointsType[1]],
							zlevel:zlevel
						};
						objUtil.deepMix(linkAttr, this.editorConfig.link);
						objUtil.deepMix(linkAttr, userAttr);
						let link =new Link(linkAttr);
						this.add(link);
					}
					this.__hoverEl=el;
				}

			})
			el.on('mouseout',(e)=>{
				if(this.__linkableHoverBox!=null){
					if(this.__linkableHoverBox._linkEditContain(e.offsetX,e.offsetY)){
						return;
					}
					if(el.contain(e.offsetX,e.offsetY)){
						return;
					}
					this.__removeBinkableHoverBox()
				}
			})

			el.on('mousedown',(e)=>{
				if(this.__linkableHoverBox!=null){
					this.__removeBinkableHoverBox()
				}
			})
			el.on('dragstart',(e)=>{
				this.__indrag=true;
			})
			el.on('dragend',(e)=>{
				this.__indrag=false;
			})

		}
	}
	__removeShapeEditBox(){
		this.__shapEditBox.destroy();
		this.__shapEditBox=null;
		this.__editEl=null;
	}
	__removeBinkableHoverBox(){
		this.__linkableHoverBox.destroy();
		this.__linkableHoverBox=null;
		this.__hoverEl=null;
	}
	/**
	 * @method 删除元素
	 * @author DingJianFei
	 * @date 2019/6/6
	 */
	remove(el){
		if(this.__selectedElement!=null&&el==this.__selectedElement){
			if(this.__linkableHoverBox){
				this.__removeBinkableHoverBox();
			}
			if(this.__shapEditBox){
				this.__removeShapeEditBox();
			}
		}
		if(el.parent!=this){
			el.parent.remove(el);
		}else{
			super.remove(el)
		}
	}
	/**
	 * @method 返回当前被选中的元素
	 * @author DingJianFei
	 * @date 2019/6/10
	 */
	getSelected(){
		return this.__selectedElement;
	}
	/**
	 * @method 返回编辑器里的所有可编辑元素
	 * @author DingJianFei
	 * @date 2019/6/10
	 */
	getEditedElment(){
		var list=[];
		var f=function (children) {
			for(let v of children){
				if(v.isEditable&&!v.unEdit){
					list.push(v)
				}
				if(v.isGroup){
					f(v.children());
				}
			}
		}
		f(this.children());
		return list;
	}
	/**
	 * @method 选中物体回调
	 * @author DingJianFei
	 * @date 2019/6/20
	 */
	selectedAfter=null;
	/**
	 * @method 取消选中物体回调
	 * @author DingJianFei
	 * @date 2019/6/20
	 */
	unselectedAfter=null;
	/**
	 * @method 触发连线前的回调
	 * @author DingJianFei
	 * @date 2019/6/17
	 */
	linkbefore=null;
}
