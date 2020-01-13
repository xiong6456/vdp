$(function(){
    function initToolbarBootstrapBindings() {
        var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
                'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
                'Times New Roman', 'Verdana'],
            fontTarget = $('[title=Font]').siblings('.dropdown-menu');
        $.each(fonts, function (idx, fontName) {
            fontTarget.append($('<li><a data-edit="fontName ' + fontName +'" style="font-family:\''+ fontName +'\'">'+fontName + '</a></li>'));
        });
        $('a[title]').tooltip({container:'body'});
        $('.dropdown-menu input').click(function() {return false;})
            .change(function () {$(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');})
            .keydown('esc', function () {this.value='';$(this).change();});

        $('[data-role=magic-overlay]').each(function () {
            var overlay = $(this), target = $(overlay.data('target'));
            overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
        });
        $('#voiceBtn').hide();
        if ("onwebkitspeechchange"  in document.createElement("input")) {
            var editorOffset = $('#editor').offset();
            $('#voiceBtn').css('position','absolute').offset({top: editorOffset.top, left: editorOffset.left+$('#editor').innerWidth()-35});
        } else {
            $('#voiceBtn').hide();
        }
    };
    function showErrorAlert (reason, detail) {
        var msg='';
        if (reason==='unsupported-file-type') {
            msg = "Unsupported format " +detail;
        } else {
            console.log("error uploading file", reason, detail);
        }
        $('<div class="alert"> <button type="button" class="close" data-dismiss="alert">×</button>'+
            '<strong>File upload error</strong> '+msg+' </div>').prependTo('#alerts');
    };
    initToolbarBootstrapBindings();
    $('#editor').wysiwyg({ fileUploadError: showErrorAlert} );
});


// 照片路径保存
var uploadFiles = [];
// 监听选取照片的按钮<input type="file" data-role="magic-overlay" data-target="#pictureBtn" data-edit="insertImage" />，
// 把每次选取的照片文件放入数组中
$("#descripitionImg").change(function(){
    $.each(this.files,function(index,fileObj){
        uploadFiles.push(fileObj);
    });
});

// 转码照片为base64的字符串
var readFileIntoDataUrl = function (fileInfo) {
    var loader = $.Deferred(),
        fReader = new FileReader();
    fReader.onload = function (e) {
        loader.resolve(e.target.result);
    };
    fReader.onerror = loader.reject;
    fReader.onprogress = loader.notify;
    fReader.readAsDataURL(fileInfo);
    return loader.promise();
};
function uploadImgs(index){
    // 使用FormData对象上传文件
    // 这里上传使用递归上传，上传一个再次调用函数本身，再次上传，知道全部上传完成
    var formData = new FormData();
    if(0 >= index){
        // 再次上传文本编辑器里的内容
    }else{
        //console.log('执行照片提交。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。');
        index -=1;
        formData.append(uploadFiles[index].name,uploadFiles[index]);
        var xhr = new XMLHttpRequest();
        xhr.open("POST",FILEUPLOAD_URL2,true);
        xhr.send(formData);
        xhr.onload = function(data){
            // 判断图片是否存在
            var imgTag = [];
            readFileIntoDataUrl(uploadFiles[index]).done(function (dataUrl) {
                imgTag = $("#editor").find("img[src='" + dataUrl + "']");
                if (imgTag.length > 0) {
                    // 图片存在, 上传当前文件.
                    // uploadImage方法为你的上传图片方法.
                    var url = JSON.parse(data.currentTarget.response).resMsg;
                    imgTag.attr("src", url);
                    // 重新调用函数
                    uploadImgs(index);

                }

            });
        }
    }
}
