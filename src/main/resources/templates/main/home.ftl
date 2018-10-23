<div class="align_center">
    <h2>WelCome BStroy</h2>
    <form name="frm" id="frm" method="post">
    <input type="hidden" name="prevURI" <#if prevURI?exists>value="${prevURI}"</#if>/>
        <button type="button" class="button" onclick="fn_join();">회원가입</button>
        <button type="button" class="button" onclick="fn_list('/member');">목록</button>
    </form>
</div>    