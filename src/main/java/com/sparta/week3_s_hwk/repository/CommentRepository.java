package com.sparta.week3_s_hwk.repository;


import com.sparta.week3_s_hwk.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    //Blog클래스에서 Blog가 테이블임을 명시하자 @Entity

    List<Comment> findAllByOrderByModifiedAtDesc();
    //findAll By OrderBy ModifiedAt Desc 수정시간된 날짜를 기준으로 내림차순으로 정렬해줘(최신순으로 정렬해줘)
    //최신순으로 정렬하는 SQL문을 JPA가 다 알아서 짜준다.
}
