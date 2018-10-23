// 회원가입 체크 함수
function fn_validation(form){
    // 정규식체크


    // 연락처 value값 세팅
    var phone_prefix = form.phone_prefix.value;
    var phone_1 = form.phone_1.value;
    var phone_2 = form.phone_2.value;
    form.phone.value = `${phone_prefix}-${phone_1}-${phone_2}`;

    // 메일 value값 세팅
    var mail_1 = form.mail_1.value;
    var mail_2 = form.mail_2.value;
    form.mail.value = `${mail_1}@${mail_2}`;
    return true;
}
// 가입실행 함수
function fn_submit(frm){
    var form = frm;
    if(frm == null){
        form = document.frm;
    }
    if(confirm('가입하시겠습니까 ? ') && fn_validation(form)){
        var id = form.id.value;
        form.action = `/join/${id}`;
        form.submit();
    }

    return false;
}