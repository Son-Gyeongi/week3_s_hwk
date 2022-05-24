package com.sparta.week3_s_hwk.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


//아래 @어노테이션? 이 3개는 무조건 적어놓기 하나라도 빠지면 작동 안함
@Getter //★ Getter가 없어서 데이터를 못 꺼내고 있다.(조회가 안되고 있었다.)
@MappedSuperclass // Entity가 자동으로 컬럼으로 인식합니다.
@EntityListeners(AuditingEntityListener.class) // 생성/변경 시간을 자동으로 업데이트합니다.
public abstract class TimeStamped { //추상클래스 파라미터없고 메서드만 있는거?

    @CreatedDate   //글 생성 날짜
    private LocalDateTime createdAT;

    @LastModifiedDate   //글 수정 날짜
    private LocalDateTime modifiedAt;
}
