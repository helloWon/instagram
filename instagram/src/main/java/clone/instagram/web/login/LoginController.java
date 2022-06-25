package clone.instagram.web.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import clone.instagram.domain.login.LoginService;
import clone.instagram.domain.member.Member;
import clone.instagram.domain.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final MemberService memberService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult,
            HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return "user/login";
        }

        Member loginMember = loginService.login(form.getLoginId(),
                form.getPassword());

        if (loginMember == null) {
            bindingResult.reject("loginFail", "id 또는 비밀번호 오류");
            return "../error";
        }

        Cookie idCookie = new Cookie("memberId",
                String.valueOf(loginMember.getId()));
        response.addCookie(idCookie);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletResponse response) {
        expireCookie(response);
        return "redirect:/";
    }

    @GetMapping("/join")
    public String joinForm(HttpServletResponse response) {
        return "user/join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute Member member, RedirectAttributes redirectAttributes) {
        memberService.join(member);
        redirectAttributes.addAttribute("name", member.getName());
        // Cookie idCookie = new Cookie("memberId",
        // String.valueOf(loginMember.getId()));
        // response.addCookie(idCookie);
        return "redirect:/user/home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    private void expireCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("memberId", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

}
