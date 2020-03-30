package io.zingoworks.datajpa.repository;

import io.zingoworks.datajpa.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional //TODO spring 트랜잭셔널이 지원해주는 기능이 많다...! <- 차이 정리해보기
class MemberJpaRepositoryTest {

    @Autowired
    private MemberJpaRepository memberJpaRepository;

    @Rollback(false)
    @Test
    void testMember() {
        Member member = new Member("memberA");
        Member savedMember = memberJpaRepository.save(member);

        Member findMember = memberJpaRepository.find(savedMember.getId());

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member);
        //equalsAndHashCode 오버라이드 안했음에도 불구하고 == 인 이유는?
        //한 트랜잭션 내에서는 동일성을 보장함 -> 별개 트랜잭션이었다면 동일하지 않았을 것임
    }
}
