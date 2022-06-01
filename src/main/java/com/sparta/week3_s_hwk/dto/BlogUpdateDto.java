package com.sparta.week3_s_hwk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//게시글 업데이트 요청 DTO

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BlogUpdateDto {
    private String title;
    private String contents;
}
