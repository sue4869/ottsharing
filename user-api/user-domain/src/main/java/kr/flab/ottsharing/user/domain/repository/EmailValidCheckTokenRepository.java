package kr.flab.ottsharing.user.domain.repository;

import kr.flab.ottsharing.user.domain.EmailValiedCheckToken;

public interface EmailValidCheckTokenRepository {

    EmailValiedCheckToken save(EmailValiedCheckToken emailToken);
}


