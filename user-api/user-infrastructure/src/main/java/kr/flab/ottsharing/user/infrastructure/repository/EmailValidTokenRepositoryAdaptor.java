package kr.flab.ottsharing.user.infrastructure.repository;

import kr.flab.ottsharing.user.domain.EmailValiedCheckToken;
import kr.flab.ottsharing.user.domain.repository.EmailValidCheckTokenRepository;
import kr.flab.ottsharing.user.infrastructure.repository.jpa.EmailValidCheckTokenJpaRepository;

public class EmailValidTokenRepositoryAdaptor implements EmailValidCheckTokenRepository {

    private final EmailValidCheckTokenJpaRepository emailTokenJpaRepository;

    public EmailValidTokenRepositoryAdaptor(EmailValidCheckTokenJpaRepository emailTokenJpaRepository) {
        this.emailTokenJpaRepository = emailTokenJpaRepository;
    }

    @Override
    public EmailValiedCheckToken save(EmailValiedCheckToken emailToken) {
        return emailTokenJpaRepository.save(emailToken);
    }

}


