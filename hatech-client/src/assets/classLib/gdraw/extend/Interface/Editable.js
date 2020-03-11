/**
 * @Author dingjianfei
 * @Date 2019/6/3
 * @Description: 可编辑元素，可以被编辑器编辑
 */
export default class {
	/**
	 * @attribute 表示自身是否可以被编辑，Boolean
	 * @author DingJianFei
	 * @date 2019/6/4
	 */
	isEditable;


	/**
	 * @attribute 表示自身的编辑类型，size||link
	 * @author DingJianFei
	 * @date 2019/6/4
	 */
	editType;

	/**
	 * @method 返回编辑点的绝对位置,size||link
	 * @return {A,B,C....}||[[x,y],[x,y]]
	 * @author DingJianFei
	 * @date 2019/6/4
	 */
	getEditPosition(){

	}
	/**
	 * @method 返回需要用到的编辑点,size
	 * @return ['A','B','C'......]
	 * @author DingJianFei
	 * @date 2019/6/4
	 */
	getShapeEditPoints(){

	}
	/**
	 * @method	通过返回值编辑自身位置和大小,size||link
	 * @param ({x,y,width,height})||（[[x,y],[x,y]]）
	 * @return
	 * @author DingJianFei
	 * @date 2019/6/19
	 */
	changeEditAttr(opts){

	}
}
