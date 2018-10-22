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
@Table(name="GUEST_LOG")
@Data
@NoArgsConstructor
public class GuestLog{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int seq;

    @Column(name="MEMBER_SEQ",nullable=true,length=20)
    private String memberSeq;

    @Column(name="IS_MEMBER",nullable=true,length=1)
    private String isMember;

    @Column(name="IP",nullable=true,length=20)
    private String ip;

    @Temporal(TemporalType.DATE)
    @Column(name="GUEST_DATE",nullable=true)
    private Date guestDate;
    
}