package kr.or.blog.common.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import kr.or.blog.entities.IdGenerator;

public interface IdGeneratorRepository extends CrudRepository<IdGenerator,String>{
    // 파라미터 이용시 @Param 이용.
    @Query("select i.seq from IdGenerator i where i.tableName = :tableName")
    public Long getNextSeq(@Param("tableName") String tableName);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update IdGenerator i set i.seq = i.seq+1 where tableName = :tableName")
    public void next(@Param("tableName") String tableName);
}