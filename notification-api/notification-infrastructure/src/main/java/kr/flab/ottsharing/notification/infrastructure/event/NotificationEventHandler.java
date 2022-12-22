package kr.flab.ottsharing.notification.infrastructure.event;

import kr.flab.ottsharing.notification.domain.event.RegisteredUserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class NotificationEventHandler {

    @Async("asyncTask")
    @EventListener
    public void handle(RegisteredUserEvent event) {
    }
}

