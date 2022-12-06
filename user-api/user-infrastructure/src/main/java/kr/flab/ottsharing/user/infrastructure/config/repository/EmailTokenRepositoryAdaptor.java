package kr.flab.ottsharing.user.infrastructure.config.repository;

import kr.flab.ottsharing.user.domain.EmailToken;
import kr.flab.ottsharing.user.domain.repository.EmailTokenRepository;
import kr.flab.ottsharing.user.infrastructure.config.repository.jpa.EmailTokenJpaRepository;

public class EmailTokenRepositoryAdaptor implements EmailTokenRepository {

    private final EmailTokenJpaRepository emailTokenJpaRepository;

    public EmailTokenRepositoryAdaptor(EmailTokenJpaRepository emailTokenJpaRepository) {
        this.emailTokenJpaRepository = emailTokenJpaRepository;
    }

    @Override
    public EmailToken save(EmailToken emailToken) {
        return emailTokenJpaRepository.save(emailToken);
    }

}


