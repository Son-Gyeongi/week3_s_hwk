package com.sparta.week3_s_hwk.dto;


import lombok.Getter;

@Getter    //멤버변수 값 읽는 Getter
public class CommentRequestDto {
    //필요한 정보를 계속 들고다니는 아이
    //네 가지 멤버변수 넣고 기본적으로 private선언 해주자
    private Long postNum;
    private String contents;
}
