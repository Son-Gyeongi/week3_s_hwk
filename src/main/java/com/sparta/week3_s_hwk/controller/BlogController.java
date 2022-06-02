package com.sparta.week3_s_hwk.controller;

import com.sparta.week3_s_hwk.dto.BlogUpdateDto;
import com.sparta.week3_s_hwk.model.Blog;
import com.sparta.week3_s_hwk.dto.BlogRequestDto;
import com.sparta.week3_s_hwk.repository.BlogRepository;
import com.sparta.week3_s_hwk.security.UserDetailsImpl;
import com.sparta.week3_s_hwk.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequiredArgsConstructor //이거와 아래 RestController 두 개 쓰면 new 어쩌고 저쩌꼬 ㅅ신경 안 써도 된다. 요청이 들어올 때 스프링이 다 알아서 해준다.
//@RestController   //다른 곳에 가서 생성이 되고 작업이 될때 스프링이 자동으로 생성해줌 / new MemoController 안써도 됨
@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class BlogController {

    private final BlogRepository blogRepository; //@RequiredArgsConstructor, @RestController써줘야함

    private final BlogService blogService;

    //첫번째 생성(작성)하는 API 만들기
    @PostMapping("/api/blogs")
    public Blog createBlog(@RequestBody BlogRequestDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        //@RequestBody BlogRequestDto requestDto 이렇게 적어줘야 전달하는 정보가 RequestDto에 자동으로 삽입된다.

        // 로그인 되어 있는 회원 테이블의 ID
        Long userId = userDetails.getUser().getId();
        // 로그인 되어 있는 회원 테이블의 username
        String username = userDetails.getUser().getUsername();

        //Blog에 저장하려면 Blog클래스 생성해야함
        Blog blog = new Blog(requestDto, username, userId);
        //저장은 blogRepository
        return blogRepository.save(blog);
        //blog 저장 ->models 패키지 아래에 blogRepository 자바파일(인터페이스로 설정) 만들자
    }

    //비밀번호 조회
//    @GetMapping("/api/blogs/password/{id}")
//    public String readPassword(@PathVariable Long id) {
//        Blog blog =blogRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
//        );
//        return blog.getPassword();
//    }

    //전체 목록을 조회하는 메서드 <= 상세 게시글 보기에 참고하자
    @GetMapping("/api/blogs")
    public List<Blog> allReadBlog(){
        return blogRepository.findAllByOrderByModifiedAtDesc();
    }

    //삭제 메서드 id==postNum
    @DeleteMapping("/api/blogs/{id}")
    public Long deleteBlog(@PathVariable Long id){
        blogRepository.deleteById(id);
        return id;
    }

    //업데이트 메서드
    @PutMapping("/api/blogs/{id}")
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogUpdateDto requestDto) {
        //id == postNum

        blogService.update(id, requestDto);
        return id;
    }


    //원하는 post번호 내용 들고오기
    @GetMapping("/api/blogs/contents/{id}")
    public Blog readDetailBlog(@PathVariable Long id) {
        Blog blog =blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );

        return blog;
    }
}
