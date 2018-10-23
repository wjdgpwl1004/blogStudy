<!DOCTYPE html>
<html lang="ko">
<#include "/template/meta.ftl">
<body>
<#include HEADER>
	<div class="wrapper">
        <#if LEFT?exists><#include LEFT></#if>
                <div class="content">
                        <div class="card">
                                <#include template>
                        </div>
                </div>
        </div>
<#include FOOTER>    
</body>
</html>