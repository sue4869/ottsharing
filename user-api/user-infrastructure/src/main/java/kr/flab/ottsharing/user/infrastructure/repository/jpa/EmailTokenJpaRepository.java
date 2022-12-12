package kr.flab.ottsharing.user.infrastructure.repository.jpa;

import kr.flab.ottsharing.user.domain.EmailValiedCheckToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailTokenJpaRepository extends JpaRepository<EmailValiedCheckToken, Long> {
}

