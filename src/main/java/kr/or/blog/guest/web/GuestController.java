package kr.or.blog.guest.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.blog.constant.Template;
import kr.or.blog.entities.Guest;
import kr.or.blog.guest.service.GuestService;

@Controller
public class GuestController {

    @Resource(name="guestService")
    private GuestService guestService;

    @RequestMapping(path="/{userId}.BStory/guest")
    public String guestList(
        Model model,
        @PathVariable(name="userId") String userId,
        @ModelAttribute("guest") Guest guest,
        HttpServletRequest request){

        guest.setMemberSeq(request.getAttribute("memberSeq").toString());
        List<Guest> guestList = guestService.getGuests(guest);
        model.addAttribute("guestList",guestList);
        model.addAttribute("template",Template.GUEST_LIST);
        return Template.MAIN;
    }
    
}