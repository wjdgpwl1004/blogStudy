package kr.or.blog.member.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.blog.constant.Template;
import kr.or.blog.entities.Member;
import kr.or.blog.member.service.MemberService;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value="/member")
    public String memberList(
        Model model
        ,HttpServletRequest request
        ,Member member){
        List<Member> memberList = memberService.getMembers(member);
        model.addAttribute("memberList",memberList);
        model.addAttribute("template",Template.MEMBER_LIST);
        return Template.MAIN;
    }

    @RequestMapping(value="/join")
    public String joinForm(Model model){
        model.addAttribute("template",Template.JOIN);
        return Template.MAIN;
    }

    @RequestMapping(value="/join/{id}",method=RequestMethod.POST)
    public String join(
        HttpServletRequest request,
        @PathVariable(name="id") String id,
        Member member
        ){
        memberService.insertMember(member);
        return "redirect:/";
    }

}