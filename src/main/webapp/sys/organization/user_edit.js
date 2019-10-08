// layui方法
layui.use(['form', 'layer'], function () {
    var form = layui.form
        ,layer = layui.layer
});

function child(obj){
    for (var key in obj){
        $("input[name='"+key+"']").val(obj[key]);
    }
}

function update() {
    var rtnFlag;
    $.ajax({
        url:"../../sys/organization/user/update",
        type:"post",
        async:false,
        data:$("form").serialize(),
        success:function(pdata){
            var tData = eval('(' + pdata + ')');
            layer.msg(tData.msg,{time:3000});
            if('success' != tData.flag){
                rtnFlag = false;
            }else{
                rtnFlag = true;
            }
        },
        error:function(e){
            return false;
        }
    });
    return rtnFlag;
}