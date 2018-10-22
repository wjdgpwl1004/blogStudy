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
    @Column(name="seq", nullable=false, length=20)
    private String seq;

    @Column(name="member_seq", nullable=false, length=20)
    private String memberSeq;

    @Column(name="menu_name", nullable=true, length=100)
    private String menuName;

    @Column(name="rec_sts", nullable=true, length=1)
    private String recSts;

    @Column(name="menu_group")
    private int menuGroup;

    @Column(name="menu_sort")
    private int menuSort;

    @Column(name="menu_depth")
    private int menuDepth;

}