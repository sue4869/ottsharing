package kr.flab.ottsharing.user.infrastructure.config.repository.jpa;

import kr.flab.ottsharing.user.domain.EmailToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailTokenJpaRepository extends JpaRepository<EmailToken, Long> {
}

