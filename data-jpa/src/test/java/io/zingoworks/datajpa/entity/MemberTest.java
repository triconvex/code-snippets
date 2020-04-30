package io.zingoworks.datajpa.entity;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

import static io.zingoworks.datajpa.entity.QMember.member;
import static io.zingoworks.datajpa.entity.QTeam.team;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Slf4j
class MemberTest {

    @PersistenceContext
    EntityManager em;

    JPAQueryFactory queryFactory;

    @BeforeEach
    void setUp() {
        queryFactory = new JPAQueryFactory(em);

        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);
        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
    }

    @Test
    void testEntity() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 10, teamA);
        Member member3 = new Member("member3", 10, teamB);
        Member member4 = new Member("member4", 10, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        em.flush();
        em.clear();

        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();

        for(Member member : members) {
            System.out.println("member = " + member);
            System.out.println("member.getTeam() = " + member.getTeam());
        }
    }

    @Test
    void stratQuerydsl() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        em.persist(new Member("member1"));

//        QMember m = new QMember("m"); or static import QMember.member

        Member findMember = queryFactory
                .select(member)
                .from(member)
                .where(member.username.eq("member1"))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    void search() {
        Member findMember1 = queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1").and(member.age.eq(10)))
                .fetchOne();

        Member findMember2 = queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1"), member.age.eq(10))
                .fetchOne();

        Member findMember3 = queryFactory
                .selectFrom(QMember.member)
                .fetchFirst();

        List<Member> members = queryFactory
                .selectFrom(member)
                .fetch();

        QueryResults<Member> membersForPagination = queryFactory
                .selectFrom(member)
                .fetchResults();

        long count = queryFactory
                .selectFrom(member)
                .fetchCount();
    }

    @Test
    void sort() {
        List<Member> member1 = queryFactory
                .selectFrom(member)
                .where(member.age.eq(10))
                .orderBy(member.age.desc(), member.username.asc().nullsLast())
                .fetch();
    }

    @Test
    void paging() {
        List<Member> members1 = queryFactory
                .selectFrom(member)
                .orderBy(member.username.desc())
                .offset(1)
                .limit(2)
                .fetch();

        QueryResults<Member> members2 = queryFactory
                .selectFrom(member)
                .orderBy(member.username.asc())
                .offset(0)
                .limit(3)
                .fetchResults();

        assertThat(members2.getTotal()).isEqualTo(3);
        assertThat(members2.getResults().size()).isEqualTo(3);
    }

    @Test
    void etc() {
        List<Tuple> tuple1 = queryFactory
                .select(
                        member.count(),
                        member.age.sum(),
                        member.age.avg(),
                        member.age.max(),
                        member.age.min())
                .from(member)
                .fetch();

        List<Tuple> tuple2 = queryFactory
                .select(team.name, member.age.avg())
                .from(member)
                .join(member.team, team)
                .groupBy(team.name)
                .fetch();

        for(Tuple tuple : tuple2) {
            log.info("{}", tuple);
        }
    }

    @Test
    void join() {
        List<Member> members1 = queryFactory
                .selectFrom(member)
                .join(member.team, team)
                .where(team.name.eq("teamA"))
                .fetch();

        List<Member> members2 = queryFactory
                .select(member)
                .from(member, team)
                .where(member.username.eq(team.name))
                .fetch();

        List<Tuple> tuple1 = queryFactory
                .select(member, team)
                .from(member)
                .leftJoin(member.team, team).on(team.name.eq("teamA"))
                .fetch();

        for(Tuple tuple : tuple1) {
            log.debug("{}", tuple);
        }

        List<Tuple> tuple2 = queryFactory
                .select(member, team)
                .from(member)
                .leftJoin(team).on(member.username.eq(team.name))
                .fetch();

        for(Tuple tuple : tuple2) {
            log.debug("{}", tuple);
        }
    }

    @PersistenceUnit
    EntityManagerFactory emf;

    @Test
    void withoutFetchJoin() {
        em.flush();
        em.clear();

        Member withoutFetchJoinMember = queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1"))
                .fetchOne();

        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(withoutFetchJoinMember.getTeam());

        assertThat(loaded).as("페치 조인 미적용").isFalse();
    }

    @Test
    void withFetchJoin() {
        em.flush();
        em.clear();

        Member withFetchJoin = queryFactory
                .selectFrom(QMember.member)
                .join(QMember.member.team, team).fetchJoin()
                .where(QMember.member.username.eq("member1"))
                .fetchOne();

        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(withFetchJoin.getTeam());

        assertThat(loaded).as("페치 조인 적용").isTrue();
    }

    @Test
    void subQuery() {
        QMember memberSub = new QMember("memberSub");

        List<Member> members1 = queryFactory
                .selectFrom(member)
                .where(member.age.eq(
                        JPAExpressions
                                .select(memberSub.age.max())
                                .from(memberSub)
                ))
                .fetch();

        List<Member> members2 = queryFactory
                .selectFrom(member)
                .where(member.age.goe(
                        JPAExpressions
                                .select(memberSub.age.avg())
                                .from(memberSub)
                ))
                .fetch();
    }

}
