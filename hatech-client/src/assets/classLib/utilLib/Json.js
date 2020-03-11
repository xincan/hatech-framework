/**
 * @Author DingJianFei
 * @Date 2018/4/4
 * @Description: json数据操作相关方法
 */
export default{
  /**
   * @method 返回根据prop按照一定规则排序后的对象集合，
   * @param (arr,prop,ascending)
     * arr:必选，需要排序的list数据;
     * prop：必选，排序基准键;
     * ascending:可选，布尔值，true为升序，false降序，默认为true;
   * @return  arr
     * arr:排序后的集合
   * @author DingJianFei
   * @date 2018/4/4
   */
  listSort:function(arr,prop,ascending=true){
    try{
      if(typeof arr[0]!="object") throw "排序错误，json数据为非object集合";
      //ip正则
      var IpReg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/
      var DateReg=/[\d]{4}[\/-]{1}[\d]{1,2}[\/-]{1}[\d]{1,2}/;
      var sortArr=arr.sort((function (property) {
        return function(a,b){
          var vA=a[property],vB=b[property];
          if(IpReg.test(vA)&&IpReg.test(vB)){       //ip地址排序
            var temp1;
            var temp2;
            temp1 = vA.split(".");
            temp2 = vB.split(".");
            for (var i = 0; i < 4; i++){
              if (temp1[i]>temp2[i]){
                return 1;
              }else if (temp1[i]<temp2[i]){
                return -1;
              }
            }
            return 0;
          }else if((!isNaN(Number(vA)))&&(!isNaN(Number(vB)))){    //数字排序
            return Number(vA)-Number(vB);
          }else if(DateReg.test(vA)&&DateReg.test(vB)){  //时间排序
            return Number(new Date(vA))-Number(new Date(vB));
          }else {
            return vA.localeCompare(vB);
          }
        }
      })(prop));
      if(ascending){
        return sortArr;
      }else{
        return sortArr.reverse()
      }
    }catch (e){
      console.error(e);
    }
  },
  /**
   * @method 返回一个数据相同的新的Json数据
   * @param (json)
     * json:json格式数据
   * @return json:
     * json:具有新的内存空间的json数据
   * @author DingJianFei
   * @date 2018/4/4
   */
  copy:function(json){
    return JSON.parse(JSON.stringify(json));
  },
  /**
   * @method 根据传入的参数返回模糊检索后符合条件的对象集合
   * @param (json,param)
     * json:必选，要检索的list数据;
     * param：必选，条件，可以使用条件对象{name:"张三"}精确检索，或者字符串"张三"全局模糊检索;
   * @return json:
     * json:查询到的list数据
   * @author DingJianFei
   * @date 2018/4/8
   */
  search:function(json,param){
    try{
      var result=[];
      if(Array.isArray(json)){
        if(json.length>0&&typeof json[0]!="object") throw "数据筛选错误，json数据为非object集合";
      }else{
        throw "数据筛选错误，json数据必须为数组";
      }
      //自定义
      if(typeof param.rule=="function"){
        for (let v of json){
          var isOk=param.rule(v,param.params);
          if(isOk){
            result.push(v);
          }
        }
      }else{//固定规则
          if(param.rule=="全字段模糊检索"){
            for (let v of json){
              for(let objKey in v ){
                if(v[objKey]){
                  if(v[objKey].indexOf(param.params)>=0){
                    result.push(v);
                    break;
                  }
                }
              }
            }
          }else if(param.rule=="固定字段模糊检索"){

            for (let v of json){
              var isOk=false;
              for(let paramKey in param.params){
                if(param.params[paramKey]==''){
                  isOk=true;
                }else{
                  for(let objKey in v ){
                    if(paramKey==objKey){
                      if(v[objKey].indexOf(param.params[paramKey])>=0){
                        isOk=true;
                      }else{
                        isOk=false;
                      }
                      break;
                    }
                  }
                }
                if(!isOk){
                  break;
                }
              }
              if(isOk){
                result.push(v);
              }
            }
          }else if(param.rule=="固定字段精确检索"){
            for (let v of json){
              var isOk=false;
              for(let paramKey in param.params){
                if(param.params[paramKey]==''){
                  isOk=true;
                }else{
                  for(let objKey in v ){
                    if(paramKey==objKey){
                      if(param.params[paramKey]==v[objKey]){
                        isOk=true;
                      }else{
                        isOk=false;
                      }
                      break;
                    }
                  }
                }
                if(!isOk){
                  break;
                }
              }
              if(isOk){
                result.push(v);
              }
            }
          }
      }
      return result;
    }catch (e){
      console.error(e);
    }
  }
}


