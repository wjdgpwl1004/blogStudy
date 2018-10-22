package kr.or.blog.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="LOGIN_LOG")
@Data
@NoArgsConstructor
public class LoginLog{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int seq;
    
    @Column(name="MEMBER_SEQ",nullable=false,length=20)
    private String memberSeq;

    @Column(name="IP",nullable=true,length=20)
    private String ip;

    @Temporal(TemporalType.DATE)
    @Column(name="LOGIN_DATE",nullable=true)
    private Date loginDate;
}