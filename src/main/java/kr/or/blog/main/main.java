package kr.or.blog.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class TestController{

    @RequestMapping(value="/")
    public String index(){
        System.out.println("june Push");
        return "/";
    }

    @RequestMapping(value="/test")
    public String test(){
        System.out.println("Test");
        return "hello";
    }
}