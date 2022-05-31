package com.sparta.week3_s_hwk.model;

import com.sparta.week3_s_hwk.dto.BlogRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor    //클래스 Blog에 기본생성자가 없다. 그래서 기본 생성자 생성하는 lombok쓰자
@Getter
@Entity       //나 단순한 클래스가 아니라 데이터베이스를 위해서 쓰이는 녀석이다
public class Blog extends TimeStamped {// 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    //비밀번호는 어떻게 하지...?
    @Column(nullable = false)
    private String password;

    //생성자에 username, title, contents 받아온다.
    public Blog(String username, String title, String contents, String password){
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.password = password;
    }

    //처음 시작 . 생성을 생각해보면 Blog 정보를 물고오는 녀석 PersonRequestDto
    public  Blog(BlogRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }

    //변경
    public void update(BlogRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
    }
}
