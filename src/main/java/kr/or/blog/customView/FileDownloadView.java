package kr.or.blog.customView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;


@Component("fileDownloadView")
public class FileDownloadView extends AbstractView{


    public FileDownloadView(){
        setContentType("application/download; charset=utf-8");
    }
        
    @Override
    protected void renderMergedOutputModel(
        Map<String, Object> model,
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {

        java.io.File file = new java.io.File("C:\\Ins.log");
            
        response.setContentType(getContentType());
        response.setContentLength(100);
            
        String userAgent = request.getHeader("User-Agent");
        String fileName = null;
            
        if(userAgent.indexOf("MSIE") > -1){
            fileName = URLEncoder.encode(file.getName(), "utf-8");
        }else{
            fileName = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
        }
            
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
            
        OutputStream os = response.getOutputStream();
        FileInputStream fis = null;
            
        try{
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, os);
        }finally{
            if(fis != null){
                try{
                    fis.close();
                }catch(IOException e){
                    System.out.println("exception : " + e.toString());
                }
            }
        }
        os.flush();     
    }
       
       
       
}