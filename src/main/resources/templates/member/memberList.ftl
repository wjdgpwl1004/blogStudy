<div class="align_center">
    <h2>MemberList</h2>
    <table class="type03">
        <tr>
            <thead>
                <th>ID</th>
                <th>NAME</th>
                <th>ADDR</th>
                <th>PHONE</th>
                <th>MAIL</th>
            </thead>
        </tr>
        <!-- memberList null 체크-->
        <#if memberList?exists>
        <#list memberList as member>
            <tr>
                <th>${member.id}</th>
                <td>${member.name}</td>
                <td>${member.addr1}</td>
                <td>${member.phone}</td>
                <td>${member.mail}</td>
            </tr>
        </#list>
        <#else>
            <tr>
                <th colspan="5" rowspan="3" style="text-align:center;">데이터가 존재하지 않습니다.</th>
            </tr>
        </#if>
    </table>

    <form name="frm" id="frm" method="post">
    <input type="hidden" name="prevURI" value="${prevURI}"/>
        <button type"button" class="button" onclick="fn_join();">회원가입</button>  
    </form>
</div>    