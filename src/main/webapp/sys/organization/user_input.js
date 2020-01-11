layui.use(['form','element'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,element = parent.layui.element
        , $ = layui.jquery;
    $("form :input.required").each(function(){
        var $required = $("<strong class='high'> *</strong>");    //创建元素
        alert($(this).parent().html())
        $(this).parent().append($required);    //追加到文档中，注意parent()方法的使用
    })
    //自定义验证规则
    form.verify({
        title: function(value){
            if(value.length < 2){
                return '姓名至少得2个字符啊';
            }
        }
        ,pass: function(value){
            if(value != '' && !/(.+){6,12}$/.test(value)){
                return '密码必须6到12位';
            }
        }
        ,cusphone: function (value) {
            if(value != '' && !/^1\d{10}$/.test(value)){
                return '请输入正确的手机号';
            }
        }
    });

    //监听提交
    form.on('submit(save)', function(data){
        saveData('save');
        return false;
    });

    form.on('submit(saveopen)', function(data){
        var rtnFalg = saveData('saveopen');
        if(rtnFalg){
            return true;
        }
        return false;
    });

    function saveData(flag) {
        $.ajax({
            url:"../../sys/organization/user/addUser",
            type:"post",
            data:$("form").serialize(),
            success:function(pdata){
                var tData = eval('(' + pdata + ')');
                if('success' != tData.flag){
                    layer.alert(tData.msg, {
                        title: '提交失败'
                    });
                    return false;
                }
                //保存
                if(flag=='save'){
                    window.parent.layui.$('#btn-refresh').click();
                    element.tabDelete('card', 'sysorganizationuserinput');

                    // parent.layui.table.reload('dateTable',{page: {curr: 1}});
                }
                //保存并新建
                if(flag=='saveopen'){
                    location.href="./user_input.html";
                }
            },
            error:function(e){

            }
        });
    }
});