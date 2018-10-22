package kr.or.blog.member.service;

import java.util.List;

import kr.or.blog.entities.Member;

public interface MemberService {
    /**
     * 회원 리스트를 조회한다.
     * @param Member - 검색조건이 담긴 member entity
     * @return 회원리스트
     */
    public List<Member> getMembers(Member member);
    
    /**
     * 회원 정보를 조회한다.
     * @param member - 검색조건이 담긴 member entity
     * @return 회원정보
     */
    public Member getMember(Member member);

    /**
     * 회원정보를 삽입한다.
     * @param Member - 삽입할 회원정보가 담긴 member entity
     */
    public void insertMember(Member member);

    /**
     * 회원정보를 수정한다.
     * @param Member - 수정할 회원정보가 담긴 member entity
     */
    public void updateMember(Member member);

    /**
     * 회원정보를 삭제한다.
     * @param - 삭제할 회원정보가 담긴 member entity
     */
    public void deleteMember(Member member);
} 