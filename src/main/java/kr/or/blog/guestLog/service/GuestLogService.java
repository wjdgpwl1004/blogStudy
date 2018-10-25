package kr.or.blog.guestLog.service;

import java.util.List;

import kr.or.blog.entities.GuestLog;

public interface GuestLogService {

    /**
     * 방문자 로그 리스트를 가져온다.
     * @param guestLog - 검색조건이 담긴 guestlog entity
     * @return guestloglist
     */
    public List<GuestLog> getGuestLogs(GuestLog guestLog);

    /**
     * 방문자 로그를 등록한다.
     * @param guestLog - 검색조건이 담긴 guestlog entity
     */
    public void insertGuestLog(GuestLog guestLog);
}