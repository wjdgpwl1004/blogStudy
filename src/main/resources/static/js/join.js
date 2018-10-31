const MSG = '사용가능한 아이디입니다.';
function obj(){
    var idCheck = false;
    var message = '이미 사용중인 아이디입니다';
    return {
        getCheckState(){
            return idCheck
        },
        setCheckState(status){
            idCheck = status;
        },
        getMessage(){
            return message;
        },
        setMessage(msg){
            message = msg;
        }
    }
};
var obj = new obj();
$(function(){
    $('#id').on('change',function(){
        obj.setCheckState(false);
    });
});

// 회원가입 체크 함수
function fn_validation(form){
    // 정규식체크
    if(!obj.getCheckState()){
        alert('아이디 중복검사를 진행해주세요.');
        return false;
    }

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
    if(confirm('가입하시겠습니까 ? ')){
        if(fn_validation(form)){
            alert('pass');
            var id = form.id.value;
            form.action = `/join/${id}`;
            form.submit();
        }
    }
    return false;
}

function idCheck(){
    var id = document.frm.id.value;
    if(id.length <= 0){
        alert('아이디를 입력해주세요.');
        return false;
    }
    
    $.ajax({
        url : `/join/${id}`,
        dataType : 'json'
    }).then(function(res){
        alert(res.result);
        if(res.result == "true"){
            obj.setCheckState(true);
            obj.setMessage(MSG);
        }
        alert(obj.getMessage());
    });
}