package kr.or.blog.board.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.blog.board.service.BoardService;
import kr.or.blog.boardMenu.service.BoardMenuService;
import kr.or.blog.constant.Template;
import kr.or.blog.entities.Board;
import kr.or.blog.entities.BoardMenu;
import kr.or.blog.entities.Member;
import kr.or.blog.member.service.MemberService;

@Controller
public class BoardController {

    @Resource(name="boardService")
    private BoardService boardService;

    @Resource(name="boardMenuService")
    private BoardMenuService boardMenuService;

    @Resource(name="memberService")
    private MemberService memberService;

    @RequestMapping(path="/{userId}.BStory/{boardSeq}",method=RequestMethod.GET)
    public String boardList(
        Model model,
        @PathVariable(name="userId") String userId,
        @PathVariable(name="boardSeq") String boardSeq,
        @ModelAttribute("board") Board board,
        @ModelAttribute("boardMenu") BoardMenu boardMenu){
        
        //해당 userId를 가지는 회원의 seq 가져오기
        Member param = new Member();
        param.setId(userId);
        String memberSeq = memberService.getMemberSeq(param);
        
        //해당 블로그의 menuList 가져오기
        boardMenu.setMemberSeq(memberSeq);
        List<BoardMenu> menuList = boardMenuService.getBoardMenus(boardMenu);

        // 해당 블로그의 boardList 가져오기
        List<Board> boardList = boardService.getBoards(board);

        model.addAttribute("menuList",menuList);
        model.addAttribute("boardList",boardList);
        model.addAttribute("template", Template.BOARD_LIST);
        return Template.MAIN;        
    }

    @RequestMapping(path="/{userId}.BStory/{boardSeq}/{seq}",method=RequestMethod.GET)
    public String boardInfo(
        Model model,
        @PathVariable(name="userId") String userId,
        @PathVariable(name="boardSeq") String boardSeq,
        @PathVariable(name="seq") String seq,
        @ModelAttribute("board") Board board){

        Board boardInfo = boardService.getBoard(board);
        model.addAttribute("board",boardInfo);
        model.addAttribute("template",Template.BOARD_INFO);
        return Template.MAIN;
    }

    @RequestMapping(path="/{userId}.BStory/{boardSeq}",method=RequestMethod.POST)
    public String insertBoard(
        @PathVariable(name="userId") String userId,
        @PathVariable(name="boardSeq") String boardSeq,
        @ModelAttribute("board") Board board){

        boardService.insertBoard(board);
        //pathvariable을 redirect시 사용할수있다.
        return "redirect:/{userId}/{boardSeq}";
    }
    
    @RequestMapping(path="/{userId}.BStory/{boardSeq}/{seq}",method=RequestMethod.DELETE)
    public String deleteBoard(
        @PathVariable(name="seq") String seq,
        @ModelAttribute("board") Board board){

        boardService.deleteBoard(board);
        return Template.MAIN;
    }

    @RequestMapping(path="/{userId}.BStory/{boardSeq}/{seq}",method=RequestMethod.PUT)
    public String updateBoard(
        @PathVariable(name="seq") String seq,
        @ModelAttribute("board") Board board){

        boardService.updateBoard(board);
        return "redirect:/{userId}/{boardSeq}";
    }
}