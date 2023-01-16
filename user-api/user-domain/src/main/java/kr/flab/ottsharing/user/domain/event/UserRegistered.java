package kr.flab.ottsharing.user.domain.event;

import kr.flab.common.ottsharing.domain.DomainEvent;

public class UserRegistered extends DomainEvent {
    private final Long id;
    private final String email;

    public UserRegistered(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}


