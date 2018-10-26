package kr.or.blog.aop;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;

import kr.or.blog.boardMenu.service.BoardMenuService;
import kr.or.blog.entities.BoardMenu;
import kr.or.blog.entities.Member;
import kr.or.blog.member.service.MemberService;

@Component
@Aspect
public class BoardMenuAop {

    @Resource(name="boardMenuService")
    private BoardMenuService boardMenuService;

    @Resource(name="memberService")
    private MemberService memberService;


    @Before("execution(* kr.or.blog.main.MainController.userMain(..))")
    public void AftereReturnBoard1(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        final Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        String userId = pathVariables.get("userId");

        //해당 userId를 가지는 회원의 seq 가져오기
        Member param = new Member();
        param.setId(userId);
        String memberSeq = memberService.getMemberSeq(param);
        
        BoardMenu boardMenu = new BoardMenu();
        //해당 블로그의 menuList 가져오기
        boardMenu.setMemberSeq(memberSeq);
        List<BoardMenu> menuList = boardMenuService.getBoardMenus(boardMenu);
        request.setAttribute("menuList",menuList);
    }

    @Before("execution(* kr.or.blog.board.web.*.*(..))")
    public void AftereReturnBoard(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        final Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        String userId = pathVariables.get("userId");
        Long boardSeq = Long.parseLong(pathVariables.get("boardSeq"));
        //해당 userId를 가지는 회원의 seq 가져오기
        Member param = new Member();
        param.setId(userId);
        String memberSeq = memberService.getMemberSeq(param);
        
        BoardMenu boardMenu = new BoardMenu();
        //해당 블로그의 menuList 가져오기
        boardMenu.setMemberSeq(memberSeq);
        List<BoardMenu> menuList = boardMenuService.getBoardMenus(boardMenu);
        request.setAttribute("menuList",menuList);
        request.setAttribute("currentMenu",boardSeq);
    }

    @Before("execution(* kr.or.blog.guest.web.*.*(..))")
    public void AfterReturnGuest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        final Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        String userId = pathVariables.get("userId");
        
        //해당 userId를 가지는 회원의 seq 가져오기
        Member param = new Member();
        param.setId(userId);
        String memberSeq = memberService.getMemberSeq(param);
        
        BoardMenu boardMenu = new BoardMenu();
        //해당 블로그의 menuList 가져오기
        boardMenu.setMemberSeq(memberSeq);
        List<BoardMenu> menuList = boardMenuService.getBoardMenus(boardMenu);
        request.setAttribute("menuList",menuList);
        request.setAttribute("memberSeq",memberSeq);
        request.setAttribute("currentMenu",-1);
    }
}