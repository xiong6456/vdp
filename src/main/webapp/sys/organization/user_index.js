// layui方法
layui.use(['table',  'layer','element'], function () {

    // 操作对象
    var table = layui.table
        , layer = layui.layer
        ,element = parent.layui.element //Tab的切换功能，切换事件监听等，需要依赖element模块
        , $ = layui.jquery;

    // 表格渲染
    var tableIns = table.render({
        id: 'fdId'
        ,elem: '#dataTable'                  //指定原始表格元素选择器（推荐id选择器）
        , height: $(window).height() - ( $('.my-btn-box').outerHeight(true) ? $('.my-btn-box').outerHeight(true) + 30 :  40 )    //容器高度
        , cols: [[                  //标题栏
            {checkbox: true, fixed: true}
            , {field: 'fdName', title: '部门名称', width: 150, sort: true}
            , {fixed: 'right', title: '操作', width: 150, align: 'center', toolbar: '#barOption'} //这里的toolbar值是模板元素的选择器
        ]]
        , id: 'dataCheck'
        , url: '/dept/selectParent'
        , method: 'get'
        , page: true
        , limits: [10, 15, 20, 30, 60, 90, 150, 300]
        , limit: 10 //默认采用10
        , loading: false
        , done: function (res, curr, count) {
            //如果是异步请求数据方式，res即为你接口返回的信息。
            //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
            console.log(res);
            return res;
            //得到当前页码
            // console.log(curr);

            //得到数据总量
            // console.log(count);
        }

    });

    // 获取选中行
    table.on('checkbox(dataCheck)', function (obj) {
        console.log(obj.checked); //当前是否选中状态
        console.log(obj.data); //选中行的相关数据
        console.log(obj.type); //如果触发的是全选，则为：all，如果触发的是单选，则为：one
    });


     //监听工具条
    table.on('tool(dataTable)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            openDetial("部门详情", ['600px', '400px'], "./DeptInput.html", "view", function() {
                // JSON.stringify(data))
            });
        } else if(obj.event === 'del'){
            layer.confirm('确认删除此数据', function(index){
                $.ajax({
                    url: "/dept/delete",
                    type: "POST",
                    data:{"id":data.fdId},
                    dataType: "json",
                    success: function(data){
                        if(data.flag){
                            obj.del();
                            layer.close(index);
                            layer.msg("删除成功", {icon: 6});
                            reloadTree();
                        }else{
                            layer.msg("删除失败", {icon: 5});
                        }
                    }

                });
            });
        } else if(obj.event === 'edit'){
            layer.alert('编辑行：<br>'+ JSON.stringify(data))
            openDetial("新增部门", ['600px', '400px'], "./DeptInput.html", "update", function() {
                layer.msg("修改成功");
            });
        }
    });
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

    table.on('checkbox(dataTable)', function(obj){
        console.log(obj)
    });

    var $ = layui.$, active = {
        reload: function(){
            var reloadData = $('#btn-refresh');

            table.reload('testReload', {
                where: {
                    keyword: reloadData.val()
                }
            });
        }
    };
});
