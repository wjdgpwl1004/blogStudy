package kr.or.blog.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kr.or.blog.entities.Board;

public interface BoardRepository extends CrudRepository<Board,Integer>{

    @Query("select b from Board b")
    public List<Board> getBoards();
}