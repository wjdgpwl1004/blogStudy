package kr.or.blog.loginLog.service;

import java.util.List;

import kr.or.blog.entities.LoginLog;

public interface LoginLogService {

    /**
     * 로그인 로그 리스트를 가져온다
     * @param loginLog - 검색조건이 담긴 loginlog entity
     * @return loginlogList
     */
    public List<LoginLog> getLoginLogs(LoginLog loginLog);
    
    /**
     * 로그인 로그를 등록한다.
     * @param loginLog 삽입할 정보가 담긴 loginlog entity
     */
    public void insertLoginLog(LoginLog loginLog);

}