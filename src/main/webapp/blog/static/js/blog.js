$(document).ready(function (e) {
    $("[chg-target]").on("click",function () {
        //目标对象
        var chgTarget = $($(this).attr("chg-target"));
        $(".col-md-3").toggleClass("col-md-3-show");
        chgTarget.toggleClass("data_list_cus");
    })
});