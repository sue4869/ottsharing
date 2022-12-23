package kr.flab.ottsharing.translator;

import kr.flab.common.ottsharing.domain.EventPublisher;

import kr.flab.ottsharing.notification.domain.event.RegisteredUserEvent;
import kr.flab.ottsharing.user.domain.event.EmailTokenGenerated;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class UserDomainEventTranslator {

    private final EventPublisher eventPublisher;

    public UserDomainEventTranslator(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Async("asyncTask")
    @TransactionalEventListener
    public void handle(EmailTokenGenerated event) {
       eventPublisher.publish(
                new RegisteredUserEvent(
                        event.getId(),
                        event.getEmail(),
                        event.getEmailCheckToken(),
                        event.getExpireDate()
                )
        );
    }
}


