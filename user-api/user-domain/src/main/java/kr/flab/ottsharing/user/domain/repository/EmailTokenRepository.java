package kr.flab.ottsharing.user.domain.repository;

import kr.flab.ottsharing.user.domain.EmailValiedCheckToken;

public interface EmailTokenRepository {

    EmailValiedCheckToken save(EmailValiedCheckToken emailToken);
}


