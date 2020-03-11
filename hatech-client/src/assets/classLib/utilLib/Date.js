/**
 * @Author DingJianFei
 * @Date 2018/4/4
 * @Description: 日期操作相关方法
 */
export default{
    formatDate:function(date,pattern){
        if (/(y+)/.test(pattern)) {
            pattern = pattern.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
        }
        let o = {
            'M+': date.getMonth() + 1,
            'd+': date.getDate(),
            'h+': date.getHours(),
            'm+': date.getMinutes(),
            's+': date.getSeconds()
        };
        for (let k in o) {
            if (new RegExp(`(${k})`).test(pattern)) {
                let str = o[k] + '';
                pattern = pattern.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : padLeftZero(str));
            }
        }
        return pattern;

    },
    //改进版
    toLocaleString:function(date,fmt) {
    var o = {
      "M+": date.getMonth() + 1, //月份
      "d+": date.getDate(), //日
      "h+": date.getHours() > 9 ? date.getHours() : ('0' + date.getHours()) * 1, //小时
      "m+": date.getMinutes() > 9 ? date.getMinutes() : ('0' + date.getMinutes()) * 1, //分
      "s+": date.getSeconds() > 9 ? date.getSeconds() : ('0' + date.getSeconds()) * 1, //秒
      "q+": Math.floor((date.getMonth() + 3) / 3), //季度
      "S": date.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
      if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
  }
}
function padLeftZero(str) {
    return ('00' + str).substr(str.length);
}
