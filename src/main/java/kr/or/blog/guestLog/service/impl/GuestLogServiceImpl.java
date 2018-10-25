package kr.or.blog.guestLog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.blog.entities.GuestLog;
import kr.or.blog.guestLog.repository.GuestLogRepository;
import kr.or.blog.guestLog.service.GuestLogService;

@Service("guestLogService")
public class GuestLogServiceImpl implements GuestLogService {

    @Autowired
    private GuestLogRepository guestLogRepository;
        /**
     * 방문자 로그 리스트를 가져온다.
     * @param guestLog - 검색조건이 담긴 guestlog entity
     * @return guestloglist
     */
    public List<GuestLog> getGuestLogs(GuestLog guestLog){
        List<GuestLog> guestLogList = guestLogRepository.findAllByMemberSeq(guestLog.getMemberSeq());
        return guestLogList;
    }

    /**
     * 방문자 로그를 등록한다.
     * @param guestLog - 검색조건이 담긴 guestlog entity
     */
    public void insertGuestLog(GuestLog guestLog){
        guestLogRepository.save(guestLog);
    }
}