import Group from "../../renderer/container/Group"
import ShowShapEditBox from './showEditorLib/ShowShapEditBox'
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
              //lineDash:[4,4],
              lineWidth:3 //选中的宽度
            }
          },
          line:{
            style:{
              stroke:'#00A6FD',
              //lineDash:[8,8],
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
  }
  type='showEditor';

  __shapEditBox= [];
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
        if(this.__shapEditBox.length > 0){
          this.__removeShapeEditBox();
        }

        if(el.isShowLinkElement){
          //1.将canvas中的节点分类存储
          let linkList = [];
          for(let node of this._children) {
            if (node.type === 'link') {
              linkList.push(node);
            }
          }
          //2.获取选中的节点，循环选中
          let selectedItem = this.getSelectedNodes(linkList,e.target);
          for (let v of selectedItem) {
            this.__shapEditBox.push(new ShowShapEditBox(v,this,this.editorConfig.selected));
          }
        }
      })

      el.on('mousedown',(e)=>{
        let el = e.target;
        //如果是区域元素，计算区域元素的范围
        if (el.isAreaElement) {
          let areaIdList = el.areaIdList;
          let parentChildren = el.parent._children;
          let upY = 0;
          let downY = 0;
          let upElementList = parentChildren.filter((item) => {
            return item.id === areaIdList[0];
          });
          let downElementList = parentChildren.filter((item) => {
            return item.id === areaIdList[1];
          })
          if (upElementList.length > 0) {
            upY = upElementList[0].getBoundingRect().y;
          }
          if (downElementList.length > 0) {
            downY = downElementList[0].getBoundingRect().y;
          }
          el.areaY = [upY,downY];
        }
      })
    }
  }
  __removeShapeEditBox(){
    for (let element of this.__shapEditBox) {
      element.destroy();
    }
    this.__shapEditBox=[];
  }

  getSelectedNodes(linkList,el){
    let upSelectedNode = this.getUpNode(linkList,[el],el);
    let downSelectedNode = this.getDownNode(linkList,[],el);
    return upSelectedNode.concat(downSelectedNode);
  }
  //向上查询选中节点
  getUpNode(linkList,selectedNode,el) {
    let selectedLinkList = linkList.filter((item) => {
      return item.to.id == el.id;
    })
    for (let node of selectedLinkList) {
      selectedNode.push(node);
      selectedNode.push(node.from);
      this.getUpNode(linkList,selectedNode,node.from);
    }
    return selectedNode;
  }
  //向下查询选中节点
  getDownNode(linkList,selectedNode,el) {
    let selectedLinkList = linkList.filter((item) => {
      return item.from.id == el.id;
    })
    for (let node of selectedLinkList) {
      selectedNode.push(node);
      selectedNode.push(node.to);
      this.getDownNode(linkList,selectedNode,node.to);
    }
    return selectedNode;
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
}
