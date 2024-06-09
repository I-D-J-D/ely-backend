package com.github.ely.domain.member;

import com.github.ely.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMilitaryId(String militaryId);

    Boolean existsByMilitaryId(String militaryId);
}
