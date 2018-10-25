package kr.or.blog.file.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.or.blog.entities.File;
import kr.or.blog.file.repository.FileRepository;
import kr.or.blog.file.service.FileService;
import kr.or.blog.util.MyFileUtil;

@Service("fileService")
public class FileServiceImpl implements FileService{

    @Autowired
    private FileRepository fileRepository;
       /**
     * 첨부파일리스트를 조회한다
     * @param file - 검색할 정보가 담긴 file entity
     * @return fileList
     */
    public List<File> getFiles(File file){
        List<File> fileList = fileRepository.findAllByBoardSeq(file.getBoardSeq());
        return fileList;
    }

    /**
     * 첨부파일정보를 가져온다.
     * @param file - 검색할 정보가 담긴 file entity
     * @return file
     */
    public File getFile(File file){
        Optional<File> optional = fileRepository.findById(file.getSeq());
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    
    /**
     * 첨부파일을 저장한다.
     * @param file - 삽입할 정보가 담긴 file entity
     */
    public void insertFile(File file){
        fileRepository.save(file);
    }

    /**
     * 첨부파일을 업로드한다.
     * 
     * @param file - 삽입할 정보가 담긴 file entity
     * @throws IOException
     * @throws IllegalStateException
     */
    public void uploadFile(MultipartHttpServletRequest multipartRequest) throws Exception{
        List<File> fileList = MyFileUtil.upload(multipartRequest);

       for(File fileEntity : fileList){
           insertFile(fileEntity);
       }

    }

    /**
     * 첨부파일을 삭제한다.
     * @param file - 삭제할 정보가 담긴 file entity
     */
    public void deleteFile(List<File> file){
        List<File> fileList = MyFileUtil.remove(file);
        for(File fileEntity : fileList){
            fileRepository.save(fileEntity);
        }
    }
}