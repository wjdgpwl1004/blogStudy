// 이동할 url들 정의
const actionURL = {
    HOME : '/',
    JOIN : '/join'

};

// 메인페이지 함수
function fn_home(){
    location.href = actionURL.HOME;
    return false;
}

// 회원가입 페이지 함수
function fn_join(frm){
    var form = frm;
    if(frm == null){
        form = document.frm;
    }
    form.action = actionURL.JOIN;
    form.submit();
    return false;
}

// 뒤로가기 함수
function fn_prev(frm){
    var form = frm;
    if(frm == null){
        form = document.frm;
    }
    form.action = form.prevURI.value;
    form.submit();
    return false;
}

// 리스트로 이동
function fn_list(url){
    if(url == null){
        return false;
    }
    var form = document.frm;
    form.action = url;
    form.submit();
    return false;
}

