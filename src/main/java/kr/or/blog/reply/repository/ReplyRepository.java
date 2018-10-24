package kr.or.blog.reply.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kr.or.blog.entities.Reply;

public interface ReplyRepository extends CrudRepository<Reply,Integer>{

    @Query("select r from Reply r where r.boardSeq = :boardSeq and r.recSts = 'A' ")
    public List<Reply> findReplyByBoardSeq(@Param("boardSeq") String boardSeq);
}