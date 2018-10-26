package kr.or.blog.boardMenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kr.or.blog.entities.BoardMenu;

public interface BoardMenuRepository extends CrudRepository<BoardMenu,Long>{

    @Query("select m from BoardMenu m where m.memberSeq = :memberSeq and m.recSts = 'A'")
    public List<BoardMenu> getBoardMenus(@Param("memberSeq") String memberSeq);
}