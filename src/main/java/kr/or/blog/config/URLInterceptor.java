package kr.or.blog.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import freemarker.template.Configuration;
import kr.or.blog.constant.Template;


/**
Spring-Boot Interceptor 설정
1. @Component를 통해 컴포넌트라고 스프링부트에게 알린다.
2. HandlerInterceptorAdapter 를 상속받는다.
3. preHandle , postHandle 등 처리하고싶은 시기에따라 Override 해준다.
 */
@Component(value="urlInterceptor")
public class URLInterceptor extends HandlerInterceptorAdapter{
    /**logback 을 이용한 로깅  */
    //private Logger logger = LoggerFactory.getLogger(URLInterceptor.class);
   
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        if(modelAndView != null){
                
            ModelMap modelmap =   modelAndView.getModelMap();
            String viewName = modelAndView.getViewName();
            
            Map<String,String> templateMap  = Template.getTemplateMap();  
            String viewTemplateName = viewName.split("/")[1].toUpperCase();
            String templateHeader = templateMap.get(viewTemplateName + "_HEADER");
            String templateLeft = templateMap.get(viewTemplateName + "_LEFT");
            String templateFooter = templateMap.get(viewTemplateName + "_FOOTER");   
            modelAndView.addObject("HEADER",templateHeader + Template.SUFFIX);
            modelAndView.addObject("LEFT",templateLeft + Template.SUFFIX);
            modelAndView.addObject("FOOTER",templateFooter + Template.SUFFIX);
            if(modelmap.containsKey("template")){
                String template = modelmap.get("template").toString();
                modelAndView.addObject("template", template + Template.SUFFIX);
            }
            
        }
    }

}