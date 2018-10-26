package kr.or.blog.constant;

import java.util.HashMap;
import java.util.Map;

public abstract class Template {
    // return templates map
    private static Map<String,String> templateMap = null;
    
    public final static String SUFFIX = ".ftl";
    // return templates
    public final static String MAIN = "template/main";
    public final static String MAIN_LEFT = "/template/left";
    public final static String MAIN_HEADER = "/template/header";
    public final static String MAIN_FOOTER = "/template/footer";

    public final static String SUB = "";
    public final static String SUB_HEADER = "";


    /* contents templates */
    public final static String HOME = "/main/home";
    public final static String JOIN = "/join/joinForm";
    //member
    public final static String MEMBER_LIST = "/member/memberList";
    //board
    public final static String BOARD_LIST = "/board/boardList";
    public final static String BOARD_INFO = "/board/boardInfo";
    public final static String BOARD_FORM = "/board/boardForm";
    //guest
    public final static String GUEST_LIST = "/guest/guestList"; 

    static{
        templateMap = new HashMap<String,String>();
        templateMap.put("MAIN", MAIN);
        templateMap.put("MAIN_HEADER", MAIN_HEADER);
        templateMap.put("MAIN_LEFT",MAIN_LEFT);
        templateMap.put("MAIN_FOOTER", MAIN_FOOTER);
    }
    
    /**
     * 동적 처리를 위한 템플릿들을 리턴.
     * @return templateMap
     */
    public static Map<String,String> getTemplateMap(){
        return templateMap;
    }
}