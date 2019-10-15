// layui方法
layui.use(['table', 'form', 'layer', 'vas_table','element'], function () {

    // 操作对象
    var form = layui.form
        , table = layui.table
        , layer = layui.layer
        , vasTable = layui.vas_table
        ,element = parent.layui.element
        , $ = layui.jquery;

    // 表格渲染
    var tableIns = table.render({
        elem: '#dateTable'                  //指定原始表格元素选择器（推荐id选择器）
        , height: vasTable.getFullHeight()    //容器高度
        , cols: [[                  //标题栏
            //                {checkbox: true, sort: true, fixed: true, space: true}
            {type: 'checkbox', fixed: 'left'}
            , {field: 'fdId', title: 'ID', width: 60}
            , {field: 'fdLoginName', title: '用户名', width: 100,align:'center'}
            , {field: 'fdName', title: '姓名', width: 110,align:'center'}
            , {field: 'fdSex', title: '姓别', width: 70,align:'center'}
            , {field: 'fdLocked', title: '是否锁定', width: 90,align:'center'
                ,templet: function(d){
                var strCheck = d.fdLocked == "1" ? "checked" : "";
                return '<input type="checkbox" name="status" lay-filter="status" lay-skin="switch" lay-text="是|否" ' +strCheck+ ' mid='+d.fdId+'>';
            }}
            , {field: 'fdPhone', title: '手机号', width: 140,align:'center'}
            , {field: 'fdEmail', title: '邮箱', width: 170,align:'center'}
            , {field: 'docCreateTime', title: '创建时间', width: 180,align:'center'
                ,templet: function(d){
                    return Format(d.docCreateTime,"yyyy-MM-dd hh:mm:ss");
                }
            }
            , { title: '操作', width: 190, align: 'center', toolbar: '#barOption'} //这里的toolbar值是模板元素的选择器
        ]]
        , id: 'dataCheck'
        //            , url: '../../backstage/json/data_table.json'
        ,url:'../../sys/organization/user/select'
        , method: 'get'
        , page: true
        , limits: [10, 15, 20, 50, 100]
        , limit: 10 //默认采用10
        , loading: false
        , done: function (res, curr, count) {
            $("[data-field='fdId']").css('display','none');
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
            // console.log(res);

            //得到当前页码
            // console.log(curr);

            //得到数据总量
            // console.log(count);
        }
    });

     //监听工具条
    table.on('tool(dataTable)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            openDetial("人员详情", ['800px', '500px'], "user_view.html", "view", data,0,function() {
                // JSON.stringify(data))
            });
        } else if(obj.event === 'del'){
            layer.confirm('确认删除此数据', function(index){
                $.ajax({
                    url: "../../sys/organization/user/delete",
                    type: "POST",
                    data:JSON.stringify({"ids":data.fdId}),
                    contentType:'application/json',
                    success: function(data){
                        data = JSON.parse(data);
                        if(data.flag){
                            tableIns.reload();
                            obj.del();
                            layer.close(index);
                            layer.msg("删除成功", {icon: 6});
                        }else{
                            layer.msg("删除失败", {icon: 5});
                        }
                    }

                });
            });
        } else if(obj.event === 'edit'){
            openDetial("人员修改", ['800px', '500px'], "user_edit.html", "update",data,0, function() {
                layer.msg("修改成功");
            });
        }
    });

    //批量删除人员
    $(document).on('click','#batchDel',function() {
       var delList=[];
        var checkStatus=table.checkStatus('dataCheck');
            data=checkStatus.data;

        data.forEach(function(n,i){
            delList.push(n.fdId);
        });
        if(delList.length == 0){
            layer.tips('请选择需要删除的行',$('#batchDel'),{
                tips:[3,'#5fb878']
            })
            return false;
        }
        layer.confirm('确认删除所有选中数据', function(index){
            $.ajax({
                url: "../../sys/organization/user/delete",
                type: "post",
                data:JSON.stringify({"ids":delList}),
                contentType:'application/json',
                success: function(data){
                    data = JSON.parse(data);
                    if(data.flag){
                        tableIns.reload();
                        layer.close(index);
                        layer.msg("删除成功", {icon: 6});
                    }else{
                        layer.msg("删除失败", {icon: 5});
                    }
                }

            });
        });
    });

    //新增人员
    $(document).on('click','#btn-add',function() {
        var card='card';
        var title = '新增人员';
        // var id=new Date().getTime();
        var id='sysorganizationuserinput';
        var flag = getTitleId(card, title);                             // 是否有该选项卡存在
        // 大于0就是有该选项卡了
        if (flag > 0) {
            id = flag;
        } else {
            element.tabAdd(card, {
                title: '<span>'+title+'</span>'
                , content: '<iframe src="./sys/organization/user_input.html" frameborder="0" ></iframe>'
                , id: id
            });
            element.tabChange(card, id);
            element.init();
        }
    });

    // 根据导航栏text获取lay-id
    function getTitleId(card, title) {
        var id = -1;
        $(parent.document).find(".layui-tab[lay-filter=" + card + "] ul li").each(function () {
            if (title === $(this).find('span').html()) {
                id = $(this).attr('lay-id');
            }
        });
        return id;
    }

    //监听是否可用状态操作
    form.on('switch(status)', function(obj){
        var id = $(this).attr('mid');
        var status='';
        obj.elem.checked?status='1':status='0';
        $.ajax({
            type: 'POST',
            url: '../../sys/organization/user/updateStatus',
            data: {pFdId : id, pStatus : status},
            dataType: "json",
            success : function(data){
                if(status == '0'){
                    layer.msg("解锁成功");
                }else{
                    layer.msg("锁定成功");
                }
                tableIns.reload();
            },
            unSuccess: function (data) {
                layer.msg("修改失败");
            }
        })
    });

    // 刷新
    $('#btn-refresh').on('click', function () {
        tableIns.reload();
    });
});
