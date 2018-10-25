package kr.or.blog.guest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.blog.entities.Guest;
import kr.or.blog.guest.repository.GuestRepository;
import kr.or.blog.guest.service.GuestService;

@Service("guestService")
public class GuestServiceImpl implements GuestService{
  
    @Autowired
    private GuestRepository guestRepository;
    /**
     * 방명록 리스트를 가져온다
     * @param guest - 검색할 정보가 담긴 guest entity
     * @return guestList
     */
    public List<Guest> getGuests(Guest guest){
        List<Guest> guestList = guestRepository.findAllByMemberSeq(guest.getMemberSeq());
        return guestList;
    }
    
    /**
     * 방명록을 등록한다.
     * @param guest - 삽입할 정보가 담긴 guest entity
     */
    public void insertGuest(Guest guest){
        guestRepository.save(guest);
    }

    /**
     * 방명록을 수정한다.
     * @param guest - 수정할 정보가 담긴 guest entity
     */
    public void updateGuest(Guest guest){
        guestRepository.save(guest);
    }

    /**
     * 방명록을 삭제한다.
     * @param guest - 삭제할 정보가 담긴 guest entity
     */
    public void deleteGuest(Guest guest){
        guest.setRecSts("D");
        guestRepository.save(guest);
    }
    
}