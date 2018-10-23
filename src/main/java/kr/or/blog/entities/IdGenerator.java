package kr.or.blog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ID_GENERATOR")
@Data
@NoArgsConstructor
public class IdGenerator {

    @Id
    @Column(name="TABLE_NAME",nullable=false,length=200)
    private String tableName;

    @Column(name="SEQ",nullable=true)
    private Long seq;
    
}