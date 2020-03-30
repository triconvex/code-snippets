package io.zingoworks.datajpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String username;

    //TODO JPA 표준스펙으로 디폴트 생성자(인자없는), 접근권한 protected까지 있어야 함, JPA의 프록싱을 위해!!!
    // 관련 레퍼런스 찾아보기
    protected Member() {
    }

    public Member(String username) {
        this.username = username;
    }
}
