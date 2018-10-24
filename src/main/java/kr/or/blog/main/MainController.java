package kr.or.blog.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.blog.constant.Template;

@Controller
public class MainController{

    @RequestMapping(path="/")
    public String home(Model model){
        model.addAttribute("template",Template.HOME);
        return Template.MAIN;
    }

    @RequestMapping(path="/{userId}.BStory")
    public String userMain(
        Model model,
        @PathVariable(name="userId") String userId){
        model.addAttribute("template",Template.HOME);
        return Template.MAIN;
    }
}