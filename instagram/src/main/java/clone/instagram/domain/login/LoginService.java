package clone.instagram.domain.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clone.instagram.domain.member.Member;
import clone.instagram.domain.member.MemberRepository;
// import clone.instagram.domain.member.MemberService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginService {

    @Autowired
    private MemberRepository memberRepository;

    public Member login(String loginId, String password) {
        log.info("login member = {}", memberRepository.findMemberByLoginId(loginId).get().getName());
        return memberRepository.findMemberByLoginId(loginId).filter(m -> m.getPassword().equals(password)).orElse(null);
    }
}
