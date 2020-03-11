/**
 * @Author DingJianFei
 * @Date 2018/5/11
 * @Description: 数学几何算法
*/
export default{
  /**
   * @method 返回两条线段的交点，不存在交点返回false
   * @param (aa, bb,cc,dd)
   * aa 线段A的第一个点，格式{x:0,y:0}
   * bb 线段A的第二个点，格式{x:0,y:0}
   * cc 线段B的第一个点，格式{x:0,y:0}
   * dd 线段B的第二个点，格式{x:0,y:0}
   * @return {x:0,y:0}或false
   * @author DingJianFei
   * @date 2018/5/11
   */
  lineSegmentIntersection:function (a, b, c, d){
    var area_abc = (a.x - c.x) * (b.y - c.y) - (a.y - c.y) * (b.x - c.x);
    var area_abd = (a.x - d.x) * (b.y - d.y) - (a.y - d.y) * (b.x - d.x);
    if ( area_abc*area_abd>0 ) {
      return false;
    }
    var area_cda = (c.x - a.x) * (d.y - a.y) - (c.y - a.y) * (d.x - a.x);
    var area_cdb = area_cda + area_abc - area_abd ;
    if (  area_cda * area_cdb > 0 ) {
      return false;
    }
    var t = area_cda / ( area_abd- area_abc );
    var dx= t*(b.x - a.x),
      dy= t*(b.y - a.y);
    return { x: a.x + dx , y: a.y + dy };
  }
}
