package kr.flab.ottsharing.user.domain.repository;

import kr.flab.ottsharing.user.domain.EmailToken;

public interface EmailTokenRepository {

    EmailToken save(EmailToken emailToken);
}
