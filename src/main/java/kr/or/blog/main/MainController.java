package kr.or.blog.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.blog.constant.Template;

@Controller
public class MainController{

    @RequestMapping(value="/index")
    public String index(){
        System.out.println("master_branch!!!");
        return "index";
    }

    @RequestMapping(value="/")
    public String home(Model model){
        model.addAttribute("template",Template.HOME);
        return Template.MAIN;
    }

    @RequestMapping(value="/test")
    public String test(){
        System.out.println("Test");
        return "hello";
    }

    @RequestMapping(value="/freemarker")
    public String freemarker(){
        System.out.println("freemarker!!");
        return "freemarker";
    }
}