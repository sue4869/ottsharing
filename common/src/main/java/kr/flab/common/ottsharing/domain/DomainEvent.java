package kr.flab.common.ottsharing.domain;

import java.time.Instant;

public abstract class DomainEvent {
    private final Instant occurred = Instant.now();
}


