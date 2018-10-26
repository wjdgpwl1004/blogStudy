
<ul class="sub_nav">
	<li><a href="/${homeUrl}">홈</a></li>
			<#if userId?exists>	
				<#if menuList?exists>
					<#list menuList as menu>
						<#assign idx = menu?index>
						<#assign menuUrl = userId+".BStory/"+menu.seq>
						<#if currentMenu?number == menu.seq><#assign menuName = menu.menuName></#if>
						<#-- 루트메뉴일경우 -->
						<#if (menu.menuDepth == 0)>
							<li>
								<a href="/${menuUrl}" <#if currentMenu?number == menu.seq> id="a_hover" </#if>>
									<span>${menu.menuName}</span>
								</a>
		
						</#if>

						<#-- 루트메뉴가 아닐경우 -->
						<#if (menu.menuDepth > 0)>
								<ul>
									<li>
										<a href="/${menuUrl}" <#if currentMenu?number == menu.seq> id="a_hover" </#if> >${menu.menuName}</a>
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
	<li><a href="/${guestUrl}" <#if currentMenu?number == -1> id="a_hover" </#if> >방명록</a></li>
</ul>
