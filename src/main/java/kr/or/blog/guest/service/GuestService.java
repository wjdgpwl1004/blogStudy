package kr.or.blog.guest.service;

import java.util.List;

import kr.or.blog.entities.Guest;

public interface GuestService {

    /**
     * 방명록 리스트를 가져온다
     * @param guest - 검색할 정보가 담긴 guest entity
     * @return guestList
     */
    public List<Guest> getGuests(Guest guest);
    
    /**
     * 방명록을 등록한다.
     * @param guest - 삽입할 정보가 담긴 guest entity
     */
    public void insertGuest(Guest guest);

    /**
     * 방명록을 수정한다.
     * @param guest - 수정할 정보가 담긴 guest entity
     */
    public void updateGuest(Guest guest);

    /**
     * 방명록을 삭제한다.
     * @param guest - 삭제할 정보가 담긴 guest entity
     */
    public void deleteGuest(Guest guest);
}