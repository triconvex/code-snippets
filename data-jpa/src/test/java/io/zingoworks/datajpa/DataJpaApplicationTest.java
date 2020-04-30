package io.zingoworks.datajpa;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.zingoworks.datajpa.entity.Member;
import io.zingoworks.datajpa.entity.QMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class DataJpaApplicationTest {

    @Autowired
    private EntityManager em;

    @Test
    void contextLoads() {

        Member member = new Member();
        em.persist(member);

        JPAQueryFactory query = new JPAQueryFactory(em);
        QMember qMember = QMember.member;

        Member result = query
                .selectFrom(qMember)
                .fetchOne();

        assertThat(result).isEqualTo(member);
        assertThat(result.getId()).isEqualTo(member.getId());
    }

}
