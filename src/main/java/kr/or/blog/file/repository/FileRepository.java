package kr.or.blog.file.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kr.or.blog.entities.File;

public interface FileRepository extends CrudRepository<File,String>{

    @Query("select f from File f where f.boardSeq = :boardSeq")
	List<File> findAllByBoardSeq(@Param("boardSeq") int boardSeq);

    
}