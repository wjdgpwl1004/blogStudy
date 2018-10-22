package kr.or.blog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="FILE")
@Data
@NoArgsConstructor
public class File{

    @Id
    @Column(name="seq",nullable=false,length=20)
    private String seq;

    @Column(name="UPNAME",nullable=true,length=200)
    private String upname;

    @Column(name="REALNAME",nullable=true,length=200)
    private String realname;

    @Column(name="SIZE",nullable=true)
    private int size;

    @Column(name="SUFFIX",nullable=true,length=20)
    private String suffix;

    @Column(name="BOARD_SEQ",nullable=false,length=20)
    private String boardSeq;
}