package kr.or.blog.boardMenu.service;

import java.util.List;

import kr.or.blog.entities.BoardMenu;

public interface BoardMenuService {

    /**
     * 게시판 메뉴들을 가져온다
     * @param boardMenu - 검색할 정보가 담긴 boardmenu entity
     * @return boardMenuList
     */
    public List<BoardMenu> getBoardMenus(BoardMenu boardMenu);
    
    /**
     * 게시판 메뉴를 등록한다
     * @param boardMenu 삽입할 정보가 담긴 boardmenu entity
     */
    public void insertBoardMenu(BoardMenu boardMenu);

    /**
     * 게시판 메뉴를 수정한다
     * @param boardMenu 수정할 정보가 담긴 boardmenu entity
     */
    public void updateBoardMenu(BoardMenu boardMenu);

    /**
     * 게시판 메뉴를 삭제한다
     * @param boardMenu 삭제할 정보가 담긴 boardmenu entity
     */
    public void deleteBoardMenu(BoardMenu boardMenu);
}