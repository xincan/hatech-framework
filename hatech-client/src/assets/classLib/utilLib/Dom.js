/**
 * @Author DingJianFei
 * @Date 2018/4/4
 * @Description: Dom操作相关方法
 */
export default{
  /**
   * @method 返回当前集合中指定位置的元素
   * @param (node)
      * node:要跳转到的Dom节点位置;
   * @return void
   * @author DingJianFei
   * @date 2018/4/4
   */
  anchor:function(node){
    document.documentElement.scrollTop=document.querySelector(node).offsetTop;
  }
}
