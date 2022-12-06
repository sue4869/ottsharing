package kr.flab.ottsharing.notification.domain.event;

import kr.flab.common.ottsharing.domain.DomainEvent;
import java.time.Instant;

public class NotificationRegistered extends DomainEvent {
    private final Long id;
    private final String email;
    private final String emailCheckToken;
    private final Instant expiredDate;


    public NotificationRegistered(Long id, String email, String emailCheckToken, Instant expiredDate) {
        this.id = id;
        this.email = email;
        this.emailCheckToken = emailCheckToken;
        this.expiredDate = expiredDate;
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

    public Instant getExpiredDateDate() {
        return expiredDate;
    }

}

