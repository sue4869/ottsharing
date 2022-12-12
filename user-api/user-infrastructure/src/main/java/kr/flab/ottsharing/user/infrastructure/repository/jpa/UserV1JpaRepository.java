package kr.flab.ottsharing.user.infrastructure.repository.jpa;

import kr.flab.ottsharing.user.domain.UserV1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserV1JpaRepository extends JpaRepository<UserV1, Long> {

    boolean existsByEmailEmail(String email);
}


