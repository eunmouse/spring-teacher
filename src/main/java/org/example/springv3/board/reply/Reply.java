package org.example.springv3.board.reply;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.springv3.board.Board;
import org.example.springv3.user.User;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Setter
@Getter
@Table(name = "reply_tb")
@Entity // DB에서 조회하면 자동 매핑이됨
public class Reply {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment 설정, 시퀀스 설정
    @Id // PK 설정
    private Integer id;

    private String comment; // 댓글 내용

    @ManyToOne(fetch = FetchType.LAZY)
    private User user; // foreign key 대신에 오브젝트 넣어줌 (ORM)

    @ManyToOne(fetch = FetchType.LAZY)
    private Board board; // foreign key 대신에 오브젝트 넣어줌 (ORM)

    @CreationTimestamp // em.persist 할때 발동 (NativeQuery 쓸 때는 발동안함)
    private Timestamp createdAt;
}