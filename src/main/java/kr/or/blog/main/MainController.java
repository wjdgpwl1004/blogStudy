package kr.or.blog.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.blog.constant.Template;

@Controller
public class MainController{

    @RequestMapping(path="/index")
    public String index(){
        System.out.println("master_branch!!!");
        return "index";
    }

    @RequestMapping(path="/")
    public String home(Model model){
        model.addAttribute("template",Template.HOME);
        return Template.MAIN;
    }

    @RequestMapping(path="/{userId}")
    public String userMain(
        Model model,
        @PathVariable(name="userId") String userId){
        return "";
    }

    @RequestMapping(path="/test")
    public String test(){
        System.out.println("Test");
        return "hello";
    }

    @RequestMapping(path="/freemarker")
    public String freemarker(){
        System.out.println("freemarker!!");
        return "freemarker";
    }
}