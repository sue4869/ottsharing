package kr.flab.common.ottsharing.domain;

public interface EventPublisher {
    void publish(DomainEvent event);
}

