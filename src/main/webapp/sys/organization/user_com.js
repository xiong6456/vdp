function child(obj) {
     $("input[name='fdId']").val(obj.fdId);
     $("input[name='fdLoginName']").val(obj.fdLoginName);
     $("input[name='fdName']").val(obj.fdName);
     $("input[name='fdPhone']").val(obj.fdPhone);
     $("input[name='email']").val(obj.email);
     $("input[name='fdIdentity']").val(obj.fdIdentity);
     $("input[name='fdPassword']").val(obj.fdPassword);
     $("input[name='radio']").val(obj.fdSex);
}