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

/**
 * Created by Hevin*Xiong on 2018/12/25.
 */
// 配置扩展方法路径
layui.config({
    base: '../../common/js/'   // 模块目录
}).extend({                         // 模块别名
    vas_nav: 'vas_nav'
    , vas_tab: 'vas_tab'
    , vas_table: 'vas_table'
});
