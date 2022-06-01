package com.sparta.week3_s_hwk.service;

import com.sparta.week3_s_hwk.dto.BlogUpdateDto;
import com.sparta.week3_s_hwk.model.Blog;
import com.sparta.week3_s_hwk.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor  //BlogRepostitory 자동 생성 /업데이트하려면 필수 어노테이셔(@)
@Service //스프링에게 BlogService가 서비스인거 알려준다. /업데이트하려면 필수 어노테이셔(@)
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional   //DB에 진짜 반영이 되어야해!! /업데이트하려면 필수 어노테이셔(@)
    //업데이트 서비스
    public void update(Long id, BlogUpdateDto requestDto) {
        //id == postNum
         Blog blog =blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );

//         if(requestDto.getUserId().equals(blog.getUserId())){
//             blog.update(requestDto); //update는 Blog 클래스에 만든다.
//         }

        blog.update(requestDto); //update는 Blog 클래스에 만든다.

    }
}
