package com.sparta.week3_s_hwk.controller;

import com.sparta.week3_s_hwk.dto.CommentRequestDto;
import com.sparta.week3_s_hwk.model.Blog;
import com.sparta.week3_s_hwk.model.Comment;
import com.sparta.week3_s_hwk.repository.CommentRepository;
import com.sparta.week3_s_hwk.security.UserDetailsImpl;
import com.sparta.week3_s_hwk.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RequiredArgsConstructor //이거와 아래 RestController 두 개 쓰면 new 어쩌고 저쩌꼬 ㅅ신경 안 써도 된다. 요청이 들어올 때 스프링이 다 알아서 해준다.
//@RestController   //다른 곳에 가서 생성이 되고 작업이 될때 스프링이 자동으로 생성해줌 / new MemoController 안써도 됨
@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class CommentController {

    private final CommentRepository commentRepository;

//    private final CommentService commentService;

    //댓글 작성
    @PostMapping("/api/blogs/comments")
    public Comment createComment(@RequestBody CommentRequestDto commentRequestDto,
                                 @AuthenticationPrincipal UserDetailsImpl userDetails) {
        //@RequestBody commentDto requestDto 이렇게 적어줘야 전달하는 정보가 RequestDto에 자동으로 삽입된다.

        // 로그인 되어 있는 회원 테이블의 ID
        Long userId = userDetails.getUser().getId();
        // 로그인 되어 있는 회원 테이블의 username
        String username = userDetails.getUser().getUsername();

        //Comment에 저장하려면 Comment클래스 생성해야함
        Comment comment = new Comment(commentRequestDto, username, userId);
        //저장은 blogRepository
        return commentRepository.save(comment);
        //blog 저장 ->models 패키지 아래에 blogRepository 자바파일(인터페이스로 설정) 만들자

    }
}
