package kr.or.blog.boardMenu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.blog.boardMenu.repository.BoardMenuRepository;
import kr.or.blog.boardMenu.service.BoardMenuService;
import kr.or.blog.entities.BoardMenu;

@Service("boardMenuService")
public class BoardMenuServiceImpl implements BoardMenuService {

    @Autowired
    private BoardMenuRepository boardMenuRepository;

   /**
     * 게시판 메뉴들을 가져온다
     * @param boardMenu - 검색할 정보가 담긴 boardmenu entity
     * @return boardMenuList
     */
    public List<BoardMenu> getBoardMenus(BoardMenu boardMenu){
        List<BoardMenu> boardMenuList = boardMenuRepository.getBoardMenus(boardMenu.getMemberSeq());
        return boardMenuList;
    }
    
    /**
     * 게시판 메뉴를 등록한다
     * @param boardMenu 삽입할 정보가 담긴 boardmenu entity
     */
    public void insertBoardMenu(BoardMenu boardMenu){
        boardMenuRepository.save(boardMenu); 
    }

    /**
     * 게시판 메뉴를 수정한다
     * @param boardMenu 수정할 정보가 담긴 boardmenu entity
     */
    public void updateBoardMenu(BoardMenu boardMenu){
        boardMenuRepository.save(boardMenu);
    }

    /**
     * 게시판 메뉴를 삭제한다
     * @param boardMenu 삭제할 정보가 담긴 boardmenu entity
     */
    public void deleteBoardMenu(BoardMenu boardMenu){
        boardMenu.setRecSts("D");
        boardMenuRepository.save(boardMenu); 
    }

}