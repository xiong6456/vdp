/**
 * 获取webapp路径
 * @returns
 */
function getContextPath() {
    var pathName=window.document.location.pathname;
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	return projectName;
}

/**
 * 获取请求路径
 * @returns
 */
function GetUrlPara() {
    var url = document.location.toString();
    var arrUrl = url.split("//");

    var end = arrUrl[1].indexOf("/");
    return arrUrl[0]+"//"+arrUrl[1].substring(0,end);
}
