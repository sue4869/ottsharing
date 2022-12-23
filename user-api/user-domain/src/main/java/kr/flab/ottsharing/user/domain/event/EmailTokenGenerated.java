package kr.flab.ottsharing.user.domain.event;

import kr.flab.common.ottsharing.domain.DomainEvent;

import java.time.Instant;

public class EmailTokenGenerated extends DomainEvent {

    private final Long id;
    private final String email;
    private final String emailCheckToken;
    private final Instant expireDate;

    public EmailTokenGenerated(Long id, String email, String emailCheckToken, Instant expireDate) {
        this.id = id;
        this.email = email;
        this.emailCheckToken = emailCheckToken;
        this.expireDate = expireDate;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailCheckToken() {
        return emailCheckToken;
    }

    public Instant getExpireDate() {
        return expireDate;
    }

}

