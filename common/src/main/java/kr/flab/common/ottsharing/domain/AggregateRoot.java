package kr.flab.common.ottsharing.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class AggregateRoot {
    private final List<DomainEvent> events = new ArrayList<>();

    public void raise(DomainEvent domainEvent) {
        this.events.add(domainEvent);
    }

    public List<DomainEvent> occurredEvents() {
        List<DomainEvent> occurredEvents = List.copyOf(this.events);
        this.events.clear();
        return occurredEvents;
    }
}


