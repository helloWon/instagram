package clone.instagram.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String phoneNum;

    @Column(length = 50)
    private String email;

    @Column(length = 100)
    private String password;

    private int profileImgId;

    @Column(length = 150)
    private String introduce;

    // private String follow;

    // @Embedded
    // private Address address;

    // @OneToMany(mappedBy = "member")
    // private List<Order> orders = new ArrayList<>();
}
