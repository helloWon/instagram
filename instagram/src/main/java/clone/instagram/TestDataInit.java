package clone.instagram;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import clone.instagram.domain.member.Member;
import clone.instagram.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setLoginId("testuser");
        member.setPassword("password");
        member.setEmail("test@gmail.com");
        member.setName("tester");
        member.setPhoneNum("1234-5678");
        memberRepository.save(member);
    }
}
