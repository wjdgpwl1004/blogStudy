package kr.or.blog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="BOARD_MENU")
@Data
@NoArgsConstructor
public class BoardMenu{

    @Id
    @Column(name="SEQ", nullable=false)
    private Long seq;

    @Column(name="MEMBER_SEQ", nullable=false, length=20)
    private String memberSeq;

    @Column(name="MENU_NAME", nullable=true, length=100)
    private String menuName;

    @Column(name="REC_STS", nullable=true, length=1)
    private String recSts;

    @Column(name="MENU_GROUP")
    private int menuGroup;

    @Column(name="MENU_SORT")
    private int menuSort;

    @Column(name="MENU_DEPTH")
    private int menuDepth;

}