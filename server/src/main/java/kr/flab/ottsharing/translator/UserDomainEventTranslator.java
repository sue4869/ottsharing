package kr.flab.ottsharing.translator;

import kr.flab.common.ottsharing.domain.EventPublisher;

import kr.flab.ottsharing.notification.domain.event.NotificationRegistered;
import kr.flab.ottsharing.user.domain.event.EmailTokenGenerated;
import kr.flab.ottsharing.user.domain.event.UserEmailVerified;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class UserDomainEventTranslator {

    private final EventPublisher eventPublisher;

    public UserDomainEventTranslator(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Async
    @TransactionalEventListener
    public void handle(EmailTokenGenerated event) {
       eventPublisher.publish(
                new NotificationRegistered(
                        event.getId(),
                        event.getEmail(),
                        event.getEmailCheckToken(),
                        event.getExpireDate()
                )
        );
    }
}

