/**
 * Created by HevinXiong on 2018/12/25.
 * @name:   admin 后台 表格JS功能
 * @author: 随丶
 */
layui.define('layer', function (exports) {

    // 封装方法
    var mod = {
        // 添加选项卡 [操作对象，标签标题，url地址]
        add: function (elem, tit, url) {
            parent.addTab(elem, tit, url);
        }
        // 获取当前选中的选项卡的lay-id
        ,getThisTabId: function () {
            // 获取并返回 id
            return parent.getThisTabID();
        }
        // 删除选项卡[标签lay-id]
        ,del: function (id) {
            parent.delTab(id);
        }
    };

    // 输出
    exports('vas_tab', mod);
});


