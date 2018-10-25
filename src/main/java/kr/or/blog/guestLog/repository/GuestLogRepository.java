package kr.or.blog.guestLog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kr.or.blog.entities.GuestLog;

public interface GuestLogRepository extends CrudRepository<GuestLog,Integer>{

    @Query("select g from GuestLog g where g.memberSeq = :memberSeq ")
	List<GuestLog> findAllByMemberSeq(String memberSeq);

}