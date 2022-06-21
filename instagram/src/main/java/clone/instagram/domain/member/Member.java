package clone.instagram.domain.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(length = 20)
    private String loginId;

    @NotEmpty
    @Column(length = 20)
    private String name;

    @NotEmpty
    @Column(length = 100)
    private String password;

    // FIXME: phoneNum or email 둘 중 하나 필수
    @Column(length = 20)
    private String phoneNum;

    @Column(length = 50)
    private String email;

    private int profileImgId;

    @Column(length = 150)
    private String introduce;

    @Column(length = 300)
    private String follow;
}
