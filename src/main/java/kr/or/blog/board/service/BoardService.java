package kr.or.blog.board.service;

import java.util.List;

import kr.or.blog.entities.Board;

public interface BoardService {

    /**
     * 게시판 목록을 조회한다.
     * @param board - 검색조건이 담긴 board entity
     * @return Board List 
     */
    public List<Board> getBoards(Board board);

    /**
     * 게시판 상세조회
     * @param board - 조회 정보가 담긴 board entity
     * @return Board
     */
    public Board getBoard(Board board);

    /**
     * 게시물 등록
     * @param board - 삽입할 정보가 담긴 board entity
     */
    public void insertBoard(Board board);

    /**
     * 게시물 수정
     * @param board - 수정할 정보가 담긴 board entity
     */
    public void updateBoard(Board board);

    /**
     * 게시글 삭제
     * @param board - 삭제할 정보가 담긴 board entity
     */
    public void deleteBoard(Board board);
}