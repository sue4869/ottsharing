package kr.flab.ottsharing.notification.infrastructure.event;

import kr.flab.ottsharing.notification.domain.event.NotificationRegistered;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventHandler {

    @EventListener
    public void handle(NotificationRegistered event) {

    }
}

