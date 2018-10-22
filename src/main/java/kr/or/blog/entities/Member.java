package kr.or.blog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="MEMBER")
@Data
@NoArgsConstructor
public class Member{

    @Id
    private String seq;

    @Column(name="ID", nullable=false, length=100)
    private String id;

    @Column(name="PASSWORD", nullable=false, length=100)
    private String password;

    @Column(name="NAME", nullable=true, length=100)
    private String name;

    @Column(name="ZIPCODE", nullable=true, length=5)
    private String zipcode;

    @Column(name="ADDR1", nullable=true, length=100)
    private String addr1;

    @Column(name="ADDR2", nullable=true, length=200)
    private String addr2;

    @Column(name="PHONE", nullable=true, length=13)
    private String phone;

    @Column(name="MAIL", nullable=true, length=200)
    private String mail;
}