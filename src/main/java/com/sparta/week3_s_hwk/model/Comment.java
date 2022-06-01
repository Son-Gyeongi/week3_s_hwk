package com.sparta.week3_s_hwk.model;


import com.sparta.week3_s_hwk.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get함수(변수를 읽게 해주는 함수)를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Comment extends TimeStamped {// 생성,수정 시간을 자동으로 만들어줍니다.

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long commentNum;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private Long postNum;

    @Column(nullable = false)
    private Long userId;

    //코멘트 등록
    public  Comment(CommentRequestDto requestDto, String username, Long userId){
        this.username = username;
        this.contents = requestDto.getContents();
        this.postNum = requestDto.getPostNum();
        this.userId = userId;
    }
}
