package kr.or.blog.common.service;

public interface IdGenService {
    /**
     * 
     * @param tableName - 테이블명 
     * @param prefix - 앞에 붙일글자 
     * @param length - 최대길이
     * @return
     */
    public String generateId(String tableName, String prefix, int length);
    
}