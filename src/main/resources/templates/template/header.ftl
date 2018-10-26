<#if userId?exists>
	<#assign homeUrl = userId + ".BStory">
	<#assign guestUrl = userId + ".BStory/guest">
<#else>
	<#assign homeUrl = "#">
	<#assign guestUrl = "#">
</#if>
<#if currentMenu?exists><#else><#assign currentMenu = -10></#if>
${currentMenu}
	<div class="header">
		<h1 class="logo">
			<a href="/"><span>B</span>STORY</a>
		</h1>
		<div class="nav">
			<ul>
				<li><a href="/login">로그인</a></li>
				<li><a href="/join">회원가입</a></li>
			</ul>
		</div>
		<a href="#" class="sitemap" id="mobile_menu_btn">sitemap</a>
		<div id="mobile_menu">
			<div class="mobile_menu_head">
				<a href="/login" class="mobile_logo">
					로그인
				</a>
				<a href="/join" class="mobile_logo2">
					회원가입
				</a>
			</div>
			<ul id="gnb_device">
				<li class="th1 n1 arcodian">
					<a href="/${homeUrl}" class="th1_lnk">
						<span>홈</span>
					</a>
				</li>
			<#if userId?exists>	
				<#if menuList?exists>
					<#list menuList as menu>
						<#assign idx = menu?index>
						<#-- 루트메뉴일경우 -->
						<#if (menu.menuDepth == 0)>
							<li class="th1 n1 arcodian">
								<a href="/${userId}.BStory/${menu.seq}" <#if currentMenu?number == menu.seq>class="a_hover"</#if>>
									<span>${menu.menuName}</span>
								</a>
		
						</#if>

						<#-- 루트메뉴가 아닐경우 -->
						<#if (menu.menuDepth > 0)>
								<ul class="depth2_ul summry">
									<li>
										<a href="/${userId}.BStory/${menu.seq}" <#if currentMenu?number == menu.seq>class="a_hover"</#if>>${menu.menuName}</a>
									</li>
								</ul>
						</#if>

						<#-- 다음메뉴가 루트메뉴 일경우 li태그닫기 -->
						<#if ( menu_has_next && (menuList[index+1].depth == 0) ) || menu_has_next == false >
							</li>
						</#if>
					</#list>
				</#if>
			</#if>

				<li class="th1 n1 arcodian">
					<a href="/${guestUrl}" class="th1_lnk">
						<span>방명록</span>
					</a>
				</li>
			</ul>
			<button type="button" id="mobile_menu_close">
				<span class="skip">닫기</span>
			</button>
			<script>
				var _topmenu = new topmenu('#mobile_menu','');
			</script>
		</div>
	</div>