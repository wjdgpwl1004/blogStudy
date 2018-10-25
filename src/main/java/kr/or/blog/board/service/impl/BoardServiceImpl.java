package kr.or.blog.board.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.blog.board.repository.BoardRepository;
import kr.or.blog.board.service.BoardService;
import kr.or.blog.entities.Board;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

    /**
     * 게시판 목록을 조회한다.
     * @param board - 검색조건이 담긴 board entity
     * @return Board List 
     */
    public List<Board> getBoards(Board board){
        List<Board> boardList = boardRepository.getBoards();
        return boardList;
    }

    /**
     * 게시판 상세조회
     * @param board - 조회 정보가 담긴 board entity
     * @return Board
     */
    public Board getBoard(Board board){
        Optional<Board> optional =  boardRepository.findById(board.getSeq());
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    /**
     * 게시물 등록
     * @param board - 삽입할 정보가 담긴 board entity
     */
    public void insertBoard(Board board){
        boardRepository.save(board);
    }

    /**
     * 게시물 수정
     * @param board - 수정할 정보가 담긴 board entity
     */
    @Transactional
    public void updateBoard(Board board){
        boardRepository.save(board);
    }

    /**
     * 게시글 삭제
     * @param board - 삭제할 정보가 담긴 board entity
     */
    @Transactional
    public void deleteBoard(Board board){
        boardRepository.delete(board);
    }
}