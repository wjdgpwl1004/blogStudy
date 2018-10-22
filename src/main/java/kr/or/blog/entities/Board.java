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

/**
 * @Entity 
 * 객체를 테이블과 매핑할 엔티티라고  JPA에게 알려준다. 
 * @Entity 가 붙은클래스는 JPA가 관리하는것.이를 엔티티클래스라고함.
 * 
 * * 주의사항
 * - 기본생성자는 반드시에 존재해야한다.
 * - final class, inner class, enum, interface 에는 사용할수없다.
 * - 필드에 final을 사용해서는 안된다.
 * 
 * # 속성
 * 
 * name
 * JPA가 사용할 엔티티 이름을 지정한다.
 * name 속성은 기본값으로 클래스 명을 사용하기 떄문에 name속성은 생략해도 되지만,
 * 만약 다른 패키지에 이름이 같은 엔티티가 클래스가 존재하면 name을 지정하여 충돌하지않도록해야한다.
 * 
 * 
 * @Table
 * 엔티티 클래스가 매핑할 테이블정보를 알려준다.
 * name 속성을 사용해서 Board 엔티티를 BOARD 테이블에 매핑한다.
 * 이 어노테이션을 생략하면 엔티티이름을 테이블명으로 자동매핑한다 (대소문자 구분 안함)
 * 
 * # 속성
 * 
 * name
 * 매핑할 테이블명 (default = 엔티티명))
 * 
 * schema 
 * schema 기능이 있는 데이터베이스에서 schema 를 매핑
 * 
*/
@Entity
@Table(name="BOARD")
@Data
@NoArgsConstructor
public class Board{

    /**
    @Id
    Id어노테이션을 작성하면 엔티티의 필드를 테이블의 기본키에 매핑한다.
    @Id 어노테이션이 있는 필드를 식별자 필드라고한다.
    
    기본 키 생성전략
    1) 직접할당
    기본 키를 애플리케이션에서 직접 할당하는방법.
    즉 PK 값을 직접 부여한다.

    2) 자동생성
    대리 키 사용방식, 즉 @GeneratedValue 어노테이션의 strategy 속성ㅇ ㅔ따라 기본 키값이 생성된다.

    AUTO
    DB 종류에 따라 JPA가알맞은 것을 선택한다. (오라클 = SEQUENCE, MySQL = IDENTITY)

    IDENTITY
    기본키 생성을 데이터베이스에 위임한다.
    (MySQL, PostgreSQL, SQL Server, DB2)

    SEQUENCE
    데이터베이스 시퀀스를 사용해서 기본 키를 할당한다.
    (Oracle, PostgreSQL, DB2, H2)

    Table
    키 생성 전용 테이블을 만들어서 sequence처럼 사용한다.
    */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int seq;

    /**
    @Column
    엔티티의 필드를 테이블의 칼럼에 매핑한다. 
     
    # 속성
    name
    필드와 매핑할 테이블의 컬럼이름 (default = 필드명)

    nullable
    null값의 허용 여부를 설정한다.
    기본값은 true, false일 경우테이블 정의시 필드에 not null 제약조건이 붙는다.

    length 
    문자 길이 제약조건으로 기본갓은 255 이며, String 타입에만 적용가능하다.
     */
    @Column(name="board_seq", nullable=false, length=20)
    private String boardSeq;
    
    @Column(name="board_name", nullable=true, length=100)
    private String boardName;

    @Column(name="board_title", nullable=true, length=200)
    private String boardTitle;

    @Column(name="board_content",nullable=true, length=4000)
    private String boardContent;

    @Column(name="board_writer", nullable=true, length=20)
    private String boardWriter;

    @Column(name="rec_sts", nullable=true, length=1)
    private String recSts;

    @Column(name="board_secret", nullable=true, length=1)
    private String boardSecret;

    @Column(name="board_password", nullable=true)
    private int boardPassword;

    @Column(name="board_hit", nullable=true)
    private int boardHit;

    @Column(name="board_good", nullable=true)
    private int boardGood;

    @Column(name="board_bad", nullable=true)
    private int boardBad;


    /**
    @Temporal
    날짜타입을 매핑할때 사용한다.
    자바에서는 camel표기법 , db에서는 snake표기법을 따랐음. 
    
    # 속성
    TempoalType.DATE : 날자, 데이터베이스 date타입과매핑 2013-10-11
    TemporalType.TIME : 시간, 데이터베이스 time타입과매핑 11:11:11
    TemporalType.TIMESTAMP : 날짜와 시간, 데이터베이스 timestamp와 매핑 2013-10-11 11:11:11
     */
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Temporal(TemporalType.DATE)
    private Date updateDate;

    /**
    @Transient
    transient 어노테이션이 있는필드는 매핑이 이루어지지않는다.
    데이터베이스에 저장도않고 조회도하지않음. 
      
     
    @Enumerated
    자바의 enum타입을 매핑할때 사용한다.

    # 속성
    EnumType.ORDINAL : enum 의 순서를 디비에 저장 - 기본값
    EnumType.STRING : enum의 이름을 디비에 저장.

    . 매핑정보가없을때
    매핑 어노테이션을생r략하면필드명 그대로 칼럼명으로 매핑한다.
     */

}