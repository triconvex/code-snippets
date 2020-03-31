package io.zingoworks.datajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"}) //Team과 같은 연관관계 속성은 포함안하는게...
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    //TODO JPA 표준스펙으로 디폴트 생성자(인자없는), 접근권한 protected까지 있어야 함, JPA의 프록싱을 위해!!!
    // 관련 레퍼런스 찾아보기

    public Member(String username) {
        this.username = username;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
