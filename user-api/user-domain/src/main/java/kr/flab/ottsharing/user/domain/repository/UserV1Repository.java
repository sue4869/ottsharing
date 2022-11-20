package kr.flab.ottsharing.user.domain.repository;

import kr.flab.ottsharing.user.domain.UserV1;

public interface UserV1Repository {
    UserV1 save(UserV1 userV1);

    boolean existsByEmail(String email);
}

