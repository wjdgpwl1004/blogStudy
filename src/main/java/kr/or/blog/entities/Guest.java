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
@Table
@Data
@NoArgsConstructor
public class Guest{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int seq;

    @Column(name="GUEST_CONTENT",nullable=false,length=200)
    private String guestContent;
    
    @Column(name="GUEST_WRITER",nullable=true,length=20)
    private String guestWriter;

    @Column(name="IS_MEMBER",nullable=true,length=1)
    private String isMember;

    @Column(name="GUEST_MAIL",nullable=true,length=100)
    private String guestMail;

    @Column(name="GUEST_PASSWORD",nullable=true,length=100)
    private String guestPassword;

    @Column(name="REC_STS",nullable=true,length=1)
    private String recSts;

    @Column(name="MEMBER_SEQ",nullable=true,length=20)
    private String memberSeq;
}