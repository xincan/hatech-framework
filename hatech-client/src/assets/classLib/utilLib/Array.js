/**
 * @Author DingJianFei
 * @Date 2018/4/4
 * @Description: 数组操作常用方法
*/
export default {
  /**
   * @method 返回数组中值的索引
   * @param (arr,val)
   * arr 要操作的数组
   * val 给定值
   * @return
   * @author DingJianFei
   * @date 2018/5/25
   */
    getIndex:function(val,arr){
      var index=-1;
      for(var i=0;i<arr.length;i++){
        if(arr[i]==val){
          index=i;
          break;
        }
      }
      return index;
    },
    /**
     * @method 移除数组中指定值
     * @param (arr, val)
         * arr 要操作的数组
         * val 给定值
     * @return
     * @author DingJianFei
     * @date 2018/4/20
     */
    removeByValue:function(arr, val) {
        for(var i=0; i<arr.length; i++) {
            if(arr[i] == val) {
                arr.splice(i, 1);
                break;
            }
        }
    },

    /**
     * @method 移除对象集合中指定key，value相等的对象
     * @param (arr, key,val)
     * arr 要操作的数组
     * key 指定key
     * val 给定值
     * @return
     * @author DingJianFei
     * @date 2018/4/20
     */
    removeByKeyValue(arr, key ,val) {
        for(var i=0; i<arr.length; i++) {
            if(arr[i][key] == val) {
                arr.splice(i, 1);
                break;
            }
        }
    }
}
