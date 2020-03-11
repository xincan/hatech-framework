/**
 * @Author DingJianFei
 * @Date 2018/4/4
 * @Description: 随机操作相关方法
 */
export default{
  /**
   * @method 返回随机色值
   * @return 16进制带井号色值
   * @author DingJianFei
   * @date 2018/6/25
   */
  getRandomColor:function(){
    return "#"+("00000"+((Math.random()*16777215+0.5)>>0).toString(16)).slice(-6);
  },
  /**
   * @method 返回随机的规定色值容差和数量的色值集合，
   * @param (difference,quantity)
   * difference:必选，颜色之间的最小差值;
   * quantity：必选，需要颜色数量;
   * @return  arr
   * arr:颜色集合
   * @author DingJianFei
   * @date 2018/6/25
   */
  getRandomColorList:function(difference,quantity){
    var colorList=[];
    for(var i=0;colorList.length<100;i++){
      var color=this.getRandomColor();
      var isOK=true;
      for(var j=0;j<colorList.length;j++){
        var a=Math.abs(parseInt(color.substring(1,3),16)-parseInt(colorList[j].substring(1,3),16));
        var b=Math.abs(parseInt(color.substring(3,5),16)-parseInt(colorList[j].substring(3,5),16));
        var c=Math.abs(parseInt(color.substring(5,7),16)-parseInt(colorList[j].substring(5,7),16));
        if(a<quantity&&b<quantity&&c<quantity){
          isOK=false;
          break;
        }
      }
      if(isOK){
        colorList.push(color);
      }
    }
  },
  /**
   * @method 返回一般计算机不会重复的的ID，
   * @author DingJianFei
   * @date 2018/8/7
   */
  getUUID:function(){
	  var s = [];
	  var hexDigits = "0123456789abcdef";
	  for (var i = 0; i < 36; i++) {
		  s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
	  }
	  s[14] = "4";
	  s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);
	  s[8] = s[13] = s[18] = s[23] = "-";

	  var uuid = s.join("");
	  return uuid;
  }

}

