package io.zingoworks.datajpa.repository;

import io.zingoworks.datajpa.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Rollback(false)
    @Test
    void testMember() {
        Member member = new Member("memberA");
        Member savedMember = memberRepository.save(member);

        //jparepository는 인터페이스...
        //spring data jpa가 구현체를 만들어준다! 마법처럼!
        //memberjparepository에 구현하던 것을 스프링이 만들어준다고 이해하면 됨

        Member findMember = memberRepository.findById(savedMember.getId()).orElseThrow(IllegalArgumentException::new);

        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member);
        //equalsAndHashCode 오버라이드 안했음에도 불구하고 == 인 이유는?
        //한 트랜잭션 내에서는 동일성을 보장함 -> 별개 트랜잭션이었다면 동일하지 않았을 것임

        System.out.println("memberRepository.getClass() = " + memberRepository.getClass());
    }
}
