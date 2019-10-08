
/**
 * 页面内弹出编辑窗口 //需要引入 layui.js layui.css文件
 * @param {} title 标题 不显示为false
 * @param {} area 大小 ["400px","500px"] 或者 "400px"--->只设置宽度
 * @param {} path 弹出页面路径
 * @param {} sucFunName 执行保存操作后再弹出页面中的保存方法名称
 * @param {} callBack 执行保存操作之后的其他操作
 * @param {} sucData 成功后传值
 * @param {} moveType 拖拽模式，0或者1
 * @returns {}
 */
function openDetial(title, area, path, sucFunName,sucData,moveType, callBack) {
    moveType = moveType==null?1:0;
    layer.open({
        type: 2,
        title: title, //不显示标题栏
        closeBtn: 2,
        area: area,
        shade: 0.8,
        id: (new Date()).valueOf(), //设定一个id，防止重复弹出 时间戳1280977330748
        btn: ['保存', '取消'],
        btnAlign: 'r',
        moveType: moveType, //拖拽模式，0或者1
        content: path,
        yes: function (index, layero) {
            var iframe = window['layui-layer-iframe' + index];
            if(iframe.update && iframe.update()){
                layer.close(index);
                window.location.reload();
                return false;
            }
            var btn = layero.find('.layui-layer-btn').find('.layui-layer-btn0');
            layer.msg("保存成功",{time:3000});
            try {
                var _ifr = btn[0].parentNode.parentNode.getElementsByClassName("layui-layer-content")[0].children[0].contentWindow ||
                    btn[0].parentNode.parentNode.getElementsByClassName("layui-layer-content")[0].children[0].children[0].contentWindow;
                var func = new Function('_ifr', "return _ifr." + sucFunName + "();");
                var flg = func(_ifr);
                if (flg == false) {
                    return false;
                } else {
                    if (callBack != null) callBack();
                    window.location.reload();
                }
            } catch (ex) {

            }
        },
        btn2: function (index, layero) {
        },
        success:function (layero,index) {
            var iframe = window['layui-layer-iframe' + index];
            if(iframe.child){
                //父界面向子界面传值,调用子页面方法
                iframe.child(sucData);
            }
        }
    });
}
