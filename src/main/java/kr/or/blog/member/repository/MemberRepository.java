package kr.or.blog.member.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kr.or.blog.entities.Member;
/**
 * 스프링 프레임워크에서는 Entity의 기본 삽입,조회,수정,삭제가 가능하도록
 * CrudRepository라는 클래스를 만들어놓았음.
 * 
 *  Repository<T,ID>
    CrudRepository<T,ID> 
    PagingAndSortingRepository<T,ID>
    JpaRepository<T,ID>
    extends 가능한 repository
    Repository 는 실제로 별 기능이 없기 때문에 가장 많이 사용되는 것은 기본적인 CRUD(Create Read Update Delete ) 기능이 있는 CrudRepository<T,ID>를 많이 사용하는 편입니다.
    혹은 페이징 처리, 검색 등이 가능한 PagingAndSortingRepository<T,ID> 이나 JPA 에 특화된 몇 개의 기능을 가진 JpaRepository<T,ID> 를 사용할 수도 있습니다.
 * 
 */

public interface MemberRepository extends CrudRepository<Member,String>{
    
    @Query("select m from Member m")
    List<Member> findAllMembers();

    @Query("select m.seq from Member m where m.id = :id")
	String findSeqById(@Param("id") String id);
}