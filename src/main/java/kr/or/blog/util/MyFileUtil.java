package kr.or.blog.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.or.blog.entities.File;
import kr.or.blog.file.repository.FileRepository;

public class MyFileUtil {

    @Value("${file.savePath}")
    private static String savePath;
    
    @Autowired
    private static FileRepository fileRepository;

    /**
     * 파일의 확장자명을 가져온다.
     * @param orginalFileName
     * @return
     */
    public static String getSuffix(String orginalFileName){
        if(!orginalFileName.contains(".")){
            return "";
        }
        return orginalFileName.split(".")[1].toLowerCase();
    } 

    public static List<File> upload(MultipartHttpServletRequest multipartRequest){
        List<File> fileList = new ArrayList<File>();
        Map<String,MultipartFile> fileMap =  multipartRequest.getFileMap();

        for(String key : fileMap.keySet()){
            MultipartFile multipartFile = fileMap.get(key);
            
            //파일명 가져오기
            String fileName = multipartFile.getOriginalFilename();
            String suffix = getSuffix(fileName);
            //파일사이즈
            Long size = multipartFile.getSize();
            //임시파일명생성
            UUID uuid = UUID.randomUUID();
            String saveFileName = uuid.toString().replace("-","");
            
            // fileEntity 생성 및 list에 추가
            File fileEntity = new File();
            fileEntity.setBoardSeq(Integer.parseInt(multipartRequest.getParameter("boardSeq")));
            fileEntity.setUpname(saveFileName);
            fileEntity.setSize(size);
            fileEntity.setRealname(fileName);
            fileEntity.setSuffix(suffix);
            fileList.add(fileEntity);

            java.io.File file = new java.io.File(savePath + saveFileName + suffix);
            try {
                multipartFile.transferTo(file);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
			}
       }

        return fileList;
    }

    /**
     * 첨부파일을 삭제한다.
     * @param files - 삭제할 정보가 담긴 fileList
     * @return fileList
     */
    public static List<File> remove(List<File> files){
        List<File> fileList = new ArrayList<File>();
        for (File file : files) {
            String fileSeq = file.getSeq();
            Optional<File> optional = fileRepository.findById(fileSeq);
            if(!optional.isPresent()){
                continue;
            }

            File searchedFile = optional.get();
            searchedFile.setRecSts("D");
            String upName = searchedFile.getUpname();
            String suffix = searchedFile.getSuffix();
            java.io.File deleteFile = new java.io.File(savePath + upName + "." + suffix);
            
            if(deleteFile.exists()){
                deleteFile.delete();
            }
            fileList.add(searchedFile);

        }
        return fileList;
    }
}