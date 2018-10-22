package kr.or.blog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="REPLY")
@Data
@NoArgsConstructor
public class Reply{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int seq;

    @Column(name="BOARD_SEQ",nullable=false,length=20)
    private String boardSeq;

    @Column(name="REPLY_CONTENT",nullable=true,length=200)
    private String replyContent;

    @Column(name="REPLY_WRITER",nullable=true,length=20)
    private String replyWriter;

    @Column(name="REPLY_SECRET",nullable=true,length=1)
    private String replySecret;

    @Column(name="IS_MEMBER",nullable=true,length=1)
    private String isMember;

    @Column(name="REPLY_GROUP",nullable=true)
    private int replyGroup;

    @Column(name="REPLY_SORT",nullable=true)
    private int replySort;

    @Column(name="REPLY_DEPTH",nullable=true)
    private int replyDepth;

    @Column(name="REC_STS",nullable=true,length=1)
    private String recSts;
}