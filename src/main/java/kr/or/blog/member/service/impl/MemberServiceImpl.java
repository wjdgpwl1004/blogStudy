package kr.or.blog.member.service.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.blog.common.service.IdGenService;
import kr.or.blog.entities.Member;
import kr.or.blog.member.repository.MemberRepository;
import kr.or.blog.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

    @Resource(name="idGenService")
    private IdGenService idGenService;
   /**
     * @params Member - 검색조건이 담긴 member entity
     * @result 회원 리스트를 조회한다.
     */
    public List<Member> getMembers(Member member){
        List<Member> resultList = null; 
        resultList = memberRepository.findAllMembers();
        return resultList;
    }
    
   /**
     * 회원 정보를 조회한다.
     * @param member - 검색조건이 담긴 member entity
     * @return 회원정보
     */
    public Member getMember(Member member){
        Optional<Member> memberInfo = memberRepository.findById(member.getId());
        Member result = null;
        if(memberInfo.isPresent())
            result = memberInfo.get();
        return result;
    }

    /**
     * @params Member - 삽입할 회원정보가 담긴 member entity
     */
    public void insertMember(Member member){
        String seq = idGenService.generateId("MEMBER", "MBER", 20);
        member.setSeq(seq);
        memberRepository.save(member);
    }

    /**
     * @params Member - 수정할 회원정보가 담긴 member entity
     */
    @Transactional
    public void updateMember(Member member){
        memberRepository.save(member);
    }

    /**
     * @params - 삭제할 회원정보가 담긴 member entity
     */
    @Transactional
    public void deleteMember(Member member){
        memberRepository.deleteById(member.getId());
    }
    
}