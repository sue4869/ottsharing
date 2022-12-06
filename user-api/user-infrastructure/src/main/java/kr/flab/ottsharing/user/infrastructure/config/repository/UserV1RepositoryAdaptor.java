package kr.flab.ottsharing.user.infrastructure.config.repository;

import kr.flab.ottsharing.user.domain.UserV1;
import kr.flab.ottsharing.user.domain.repository.UserV1Repository;
import kr.flab.ottsharing.user.infrastructure.config.repository.jpa.UserV1JpaRepository;

public class UserV1RepositoryAdaptor implements UserV1Repository {

    private final UserV1JpaRepository userV1JpaRepository;

    public UserV1RepositoryAdaptor(UserV1JpaRepository userV1JpaRepository) {
        this.userV1JpaRepository = userV1JpaRepository;
    }

    @Override
    public UserV1 save(UserV1 user) {
        return userV1JpaRepository.save(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userV1JpaRepository.existsByEmailEmail(email);
    }
}


