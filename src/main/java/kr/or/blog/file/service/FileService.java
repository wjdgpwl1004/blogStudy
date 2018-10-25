package kr.or.blog.file.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.or.blog.entities.File;

public interface FileService {

    /**
     * 첨부파일리스트를 조회한다
     * @param file - 검색할 정보가 담긴 file entity
     * @return fileList
     */
    public List<File> getFiles(File file);

    /**
     * 첨부파일정보를 가져온다.
     * @param file - 검색할 정보가 담긴 file entity
     * @return file
     */
    public File getFile(File file);
    
    /**
     * 첨부파일을 업로드한다.
     * @param file - 삽입할 정보가 담긴 file entity
     */
    public void uploadFile(MultipartHttpServletRequest multipartRequest) throws Exception;

    /**
     * 첨부파일을 삭제한다.
     * @param file - 삭제할 정보가 담긴 file entity
     */
    public void deleteFile(List<File> file);


}