
import Editor from 'wangeditor';

/**
 *
 */
class HatechEditor {

  editorDom;      // 编辑器dom对象
  editorId;       // 编辑器ID属性名称
  menus;          // 自定义菜单配置
  content;        // 编辑器内容
  display;        // 编辑器是否显示
  _saveBtnClick;   // 保存按钮触发操作

  constructor(option){
    if (Object.keys(option).length === 0) {
      return false;
    }
    this.editorId = option.id;
    this.menus = option.menus;
    this.display = option.display;
    this._saveBtnClick = option.save || null;
    if(this.editorId !== undefined && this.editorId !== null){
      if(this.menus.length > 0){
        this._initEditor();
        this._createDom();
      }
    }
  }

  /**
   * 初始化渲染富文本编辑器
   * @private
   */
  _initEditor(){
    let hatechEditor = new Editor(this.editorId);
    hatechEditor.customConfig = {
      uploadImgShowBase64: true,
      onchange: html => {
        this.content = html;
      }
    };
    hatechEditor.create();
    this.editorDom = document.getElementById(this.editorId.substring(1));
    this.editorDom.style.display = this.display;
    // 1:获取编辑器同级向上子节点
    let contentNode = this.editorDom.previousElementSibling;
    // 2:隐藏内容节点
    contentNode.style.display="none";
    // 3：将内容节点数据回填给编辑器
    hatechEditor.txt.html(contentNode.innerHTML);
    this.content = contentNode.innerHTML;

    // 4:获取编辑器同级向上子节点,隐藏悬浮按钮
    let spanNode = contentNode.previousElementSibling;
    spanNode.style.display = "none";
  }

  /**
   * 创建扩展组件
   * @private
   */
  _createDom(){

    if(this.menus.length > 0){
      for(let option of this.menus){

        let toobar = this.editorDom.getElementsByClassName("w-e-toolbar")[0],
        WEMenu = document.createElement('div'),
        iBtn = document.createElement("i");
        WEMenu.className = "w-e-menu";
        WEMenu.style.zIndex = "10001";
        iBtn.className = "hatech_" + option;
        if(option === "screen"){
          iBtn.onclick = ()=> {
            this._hatechEditScreen(iBtn);
          }
          iBtn.innerHTML = "全屏";
        }
        if(option === "save"){
          iBtn.onclick = ()=> {
            this._hatechEditSave(iBtn);
          }
          iBtn.innerHTML = "保存";
        }
        WEMenu.appendChild(iBtn);
        toobar.appendChild(WEMenu);
      }
    }

  };

  /**
   * 全屏操作
   * @param editorDom
   * @param fullscreenBtn
   * @private
   */
  _hatechEditScreen(iBtn){
    this._toggleClass(this.editorDom, 'fullscreen-editor');
    if(iBtn.innerHTML == '全屏'){
      iBtn.innerHTML = '退出全屏';
    }else{
      iBtn.innerHTML = '全屏';
    }
  };

  /**
   * 保存操作
   * @param editorId
   * @param fullscreenBtn
   * @private
   */
  _hatechEditSave(iBtn){
    if(this.content === undefined || this.content == "<p><br></p>"){
      return false;
    }
    // 1:获取编辑器同级向上子节点
    let contentNode = this.editorDom.previousElementSibling;
    // 2：隐藏编辑器
    this.editorDom.style.display = "none";
    // 3：将编辑器内容回填到同级向上兄弟节点中
    contentNode.innerHTML = this.content;
    contentNode.style.display = "block";
    // 1:获取内容节点同级向上操作按钮节点
    let spanNode = contentNode.previousElementSibling;
    spanNode.style= "";

    if(this._saveBtnClick != null){
      this._saveBtnClick(this.editorId.substring(1), this.editorDom, this.content);
    }
  };

  /**
   * 样式处理
   * @param obj
   * @param cls
   * @private
   */
  _toggleClass(obj,cls){
    if(this._hasClass(obj,cls)){
      this._removeClass(obj, cls);
    }else{
      this._addClass(obj, cls);
    }
  };

  /**
   * 判断样式
   * @param obj
   * @param cls
   * @returns {RegExpMatchArray}
   * @private
   */
  _hasClass(obj, cls) {
    return obj.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
  };

  /**
   * 添加样式
   * @param obj
   * @param cls
   * @private
   */
  _addClass(obj, cls) {
    if (!this._hasClass(obj, cls)) obj.className += " " + cls;
  };

  /**
   * 删除样式
   * @param obj
   * @param cls
   * @private
   */
  _removeClass(obj, cls) {
    if (this._hasClass(obj, cls)) {
      let reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');
      obj.className = obj.className.replace(reg, ' ');
    }
  };

};

export default HatechEditor;
