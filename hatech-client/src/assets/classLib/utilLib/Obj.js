/**
 * @Author DingJianFei
 * @Date 2018/4/4
 * @Description: 对象操作相关方法
 */
export default {
	/**
	 * @method 给对象a混入对象b的属性
	 * @param (a, b)
	 * a 要接收属性的对象
	 * b 给与属性的对象
	 * @return a
	 * @author DingJianFei
	 * @date 2018/4/24
	 */
	mix: function (a, b) {
		for (let index in b) {
			a[index] = b[index];
		}
		return a;
	},
	/**
	 * @method 通过递归深度给对象a混入对象b的属性(必须是json类数值对象)
	 * @param (a, b)
	 * a 要接收属性的对象
	 * b 给与属性的对象
	 * @return  a
	 * @author DingJianFei
	 * @date 2018/4/24
	 */
	deepMix: function (a, b) {
		for (let index in b) {
			let type = typeof b[index];
			if (type == "object" && b[index] != null) {
				if (Array.isArray(b[index])) {
					a[index] = b[index].slice(0)
				} else {
					let aType = typeof a[index];
					//如果a[index]不是一个对象，则初始化为｛｝
					if (!(aType == "object" && (!Array.isArray(b[index])) && aType != null)) {
						a[index] = {}
					}
					this.deepMix(a[index], b[index]);
				}
			} else {
				a[index] = b[index]
			}
		}
		return a;
	}
}
