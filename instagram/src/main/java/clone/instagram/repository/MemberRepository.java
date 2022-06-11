package clone.instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import clone.instagram.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
