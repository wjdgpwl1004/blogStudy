
    <script type="text/javascript" src="/js/join.js"></script>
    <h2>Join Form</h2>
    <form name="frm" id="frm" method="post" action="">
    <input type="hidden" name="prevURI" value="${prevURI}"/>
        <table class="joinForm">
            <tr>
                <th><label for="id">ID : </label></th>
                <td><input type="text" name="id" maxlength="100"/><a href="#id_check" class="btn-two cyan mini">중복검사</a></td>
            </tr>
            <tr>
                <th><label for="password"> PASSWORD : </label></th>
                <td><input type="password" name="password" maxlength="100"/></td>
            </tr>
            <tr>
                <th><label for="name">이름</label></th>
                <td><input type="text" name="name" maxlength="100"/></td>
            </tr>
            <tr>
                <th><label for="zipcode">우편번호</label></th>
                <td><input type="text" name="zipcode" readonly="readonly"/><a href="#zipcode" class="btn-two cyan mini">찾기</a></td>
            </tr>
            <tr>
                <th><label for="addr1">주소</label></th>
                <td><input type="text" name="addr1" readonly="readonly"/></td>
            </tr>
            <tr>
                <th><label for="addr2">상세주소</label></th>
                <td><input type="text" name="addr2"/></td>
            </tr>
            <tr>
                <th><label for="phone">연락처</label></th>
                <td>
                    <input type="hidden" name="phone"/>
                    <select id="phone_prefix" name="phone_prefix">
                        <option value="">선택</option>
                        <option value="010">010</option>
                        <option value="011">011</option>
                        <option value="016">016</option>
                        <option value="018">018</option>
                        <option value="019">019</option>
                    </select> -
                    <input type="text" id="phone_1" name="phone_1" size="4" maxlength="4"/> - <input type="text" id="phone_2" name="phone_2" size="4" maxlength="4"/>
                </td>
            </tr>
            <tr>
                <tr>
                    <th><label for="mail">메일</label></th>
                    <td>
                        <input type="hidden" name="mail"/>
                        <input type="text" id="mail_1" name="mail_1" maxlength="100"/> @
                        <input type="text" id="mail_2" name="mail_2" maxlength="100"/>
                    </td>
                </tr>
            </tr>
        </table>
        <div class="btnArea">
            <button type"button" class="button" onclick="fn_list('${prevURI}');">목록</button>
            <button type"button" class="button" onclick="fn_submit(document.frm);">가입</button>
        </div>
    </form>