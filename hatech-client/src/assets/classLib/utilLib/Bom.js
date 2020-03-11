/**
 * @Author DingJianFei
 * @Date 2018/5/2
 * @Description: Bom操作相关方法
 */
export default{
	/**
	 * @method 返回浏览器信息
	 * @param ()
	 * @return 字符串，浏览器名称
	 * @author DingJianFei
	 * @date 2018/5/2
	 */
	getBrowserName:function(){
		var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
		if (userAgent.indexOf("Opera") > -1) {
			return "Opera"
		};
		if (userAgent.indexOf("Firefox") > -1) {
			return "Firefox";
		}
		if (userAgent.indexOf("Chrome") > -1){
			return "Chrome";
		}
		if (userAgent.indexOf("Safari") > -1) {
			return "Safari";
		}
		if (userAgent.indexOf("Trident") > -1) {
			return "IE";
		}
		if (userAgent.indexOf("Edge") > -1) {
			return "Edge";
		}
	},
	/**
	 * @method 保存base64类型的图片，兼容（火狐、IE、谷歌）
	 * @param ()
	 * @return
	 * @author DingJianFei
	 * @date 2019/5/30
	 */
	saveImageFromBase64:function(base64,name){
		var blob = this.convertBase64UrlToBlob(base64);
		var browser=this.getBrowserName();
		if (browser == 'IE'||browser == 'Edge') {
			window.navigator.msSaveBlob(blob, name);
		} else if(browser == 'Firefox'){
			let $a = document.createElement('a');
			$a.setAttribute("href",  base64);
			$a.setAttribute("download", name);
			document.body.appendChild($a);
			$a.click();
			document.body.removeChild($a);
		}else {
			let $a = document.createElement('a');
			$a.download = name;
			$a.href = base64;
			$a.click();
		}
	},
	/**
	 * @method 将 base64 转换位 blob 对象
	 * @author DingJianFei
	 * @date 2019/5/30
	 */
	convertBase64UrlToBlob:function(base64) {
		var parts =base64.split(';base64,');
		var contentType = parts[0].split(':')[1];
		var raw = window.atob(parts[1]);
		var rawLength = raw.length;
		var uInt8Array = new Uint8Array(rawLength);
		for (var i = 0; i < rawLength; i++) {
			uInt8Array[i] = raw.charCodeAt(i);
		}
		return new Blob([uInt8Array], { type: contentType });
	}
}
