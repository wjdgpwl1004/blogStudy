package kr.or.blog.common.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.blog.common.repository.IdGeneratorRepository;
import kr.or.blog.common.service.IdGenService;
import kr.or.blog.entities.IdGenerator;

@Service("idGenService")
public class IdGenServiceImpl implements IdGenService{

    @Autowired
    private IdGeneratorRepository idGenRepository;
 /**
     * 
     * @param tableName - 테이블명 
     * @param prefix - 앞에 붙일글자 
     * @param length - 최대길이
     * @return
     */
    public String generateId(String tableName, String prefix, int length){
        Optional<IdGenerator> optional = idGenRepository.findById(tableName);
        if(!optional.isPresent()){
            IdGenerator idgnerator = new IdGenerator();
            idgnerator.setTableName(tableName);
            idGenRepository.save(idgnerator);
        }
        
        Long seq = idGenRepository.getNextSeq(tableName);
        idGenRepository.next(tableName);
        StringBuilder stringBuilder = new StringBuilder(prefix);
        stringBuilder.append(seq);

        if(length > stringBuilder.length()){
            int size = length - stringBuilder.length();
            int offset = prefix.length();
            for(int i = 0; i<size; i++){
                stringBuilder.insert(offset, "0");
            }
        }
        return stringBuilder.toString();
    }
    
}