package kr.or.blog.guest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kr.or.blog.entities.Guest;

public interface GuestRepository extends CrudRepository<Guest,Integer>{

    @Query("select g from Guest g where g.memberSeq = :memberSeq")
    public List<Guest> findAllByMemberSeq(@Param("memberSeq") String memberSeq);
}