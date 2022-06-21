package clone.instagram.domain.login;

import org.springframework.stereotype.Service;

import clone.instagram.domain.member.Member;
import clone.instagram.domain.member.MemberRepository;

@Service
public class LoginService {

    private MemberRepository memberRepository;

    public Member login(String loginId, String password) {
        return memberRepository.findMemberByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password)).orElse(null);
    }
}
