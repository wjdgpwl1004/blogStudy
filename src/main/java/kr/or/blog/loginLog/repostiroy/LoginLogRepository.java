package kr.or.blog.loginLog.repostiroy;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kr.or.blog.entities.LoginLog;

public interface LoginLogRepository extends CrudRepository<LoginLog,Integer>{

    @Query("select l from LoginLog l where l.memberSeq = :memberSeq")
	List<LoginLog> findAllByMemberSeq(String memberSeq);

    
}