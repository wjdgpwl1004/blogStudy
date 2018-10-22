package kr.or.blog.member.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.blog.entities.Member;
import kr.or.blog.member.service.MemberService;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value="/member")
    public String memberList(
        Model model
        ,HttpServletRequest request){
        System.out.println("member!!");
        Member member = new Member();
        List<Member> memberList = memberService.getMembers(member);
        model.addAttribute("memberList",memberList);
        return "member/memberList";
    }
}