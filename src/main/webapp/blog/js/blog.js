$(document).ready(function (e) {
    $("[chg-target]").on("click",function () {
        $($(this).attr("chg-target")).toggleClass("data_list_cus");
    })
});