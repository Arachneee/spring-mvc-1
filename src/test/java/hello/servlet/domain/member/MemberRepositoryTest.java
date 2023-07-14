package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member("hello", 20);

        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        Member member1 = new Member("hello", 20);

        Member savedMember = memberRepository.save(member1);

        Member member2 = new Member("hello2", 22);

        Member savedMember2 = memberRepository.save(member2);

        List<Member> allMember = memberRepository.findAll();

        assertThat(allMember.size()).isEqualTo(2);
        assertThat(allMember).contains(member1,member2);


    }

    @Test
    void clearStore() {
    }
}