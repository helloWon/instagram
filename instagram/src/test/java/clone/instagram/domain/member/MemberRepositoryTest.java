package clone.instagram.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(true)
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void save() {
        Member member = new Member();
        member.setLoginId("testId");
        member.setPassword("test!");
        member.setName("test");
        memberRepository.save(member);
    }

    @Test
    public void get() {
        Member member = new Member();
        member.setLoginId("testId");
        member.setPassword("test!");
        member.setName("test");
        Member savedMember = memberRepository.save(member);
        Member findMember = memberRepository.findMemberByLoginId(savedMember.getLoginId()).get();
        assertThat(findMember.getName()).isEqualTo(savedMember.getName());

    }
}
