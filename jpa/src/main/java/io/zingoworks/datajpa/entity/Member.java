package io.zingoworks.datajpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@ToString(of = {"id", "username", "age"}) //Team과 같은 연관관계 속성은 포함안하는게...
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY) //jpa 모든 연가ㅗㄴ관계? 매니투원?은 레이지로 깁노ㅗ세팅, 필요할때ㅡ이 거
    @JoinColumn(name = "team_id")
    private Team team;

    //TODO JPA 표준스펙으로 디폴트 생성자(인자없는), 접근권한 protected까지 있어야 함, JPA의 프록싱을 위해!!!
    // 관련 레퍼런스 찾아보기

    public Member(String username) {
        this.username = username;
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if(team != null) {
            changeTeam(team);
        }
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
