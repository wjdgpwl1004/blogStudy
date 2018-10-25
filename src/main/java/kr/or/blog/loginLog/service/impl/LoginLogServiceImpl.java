package kr.or.blog.loginLog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.blog.entities.LoginLog;
import kr.or.blog.loginLog.repostiroy.LoginLogRepository;
import kr.or.blog.loginLog.service.LoginLogService;

@Service("loginLogService")
public class LoginLogServiceImpl implements LoginLogService{

    @Autowired
    private LoginLogRepository loginLogRepository;

    /**
     * 로그인 로그 리스트를 가져온다
     * @param loginLog - 검색조건이 담긴 loginlog entity
     * @return loginlogList
     */
    public List<LoginLog> getLoginLogs(LoginLog loginLog){
        List<LoginLog> loginLogList = loginLogRepository.findAllByMemberSeq(loginLog.getMemberSeq());
        return loginLogList;
    }
    
    /**
     * 로그인 로그를 등록한다.
     * @param loginLog 삽입할 정보가 담긴 loginlog entity
     */
    public void insertLoginLog(LoginLog loginLog){
        loginLogRepository.save(loginLog);
    }
}