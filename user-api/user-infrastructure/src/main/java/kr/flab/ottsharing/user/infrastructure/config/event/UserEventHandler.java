package kr.flab.ottsharing.user.infrastructure.config.event;

import kr.flab.ottsharing.user.application.processor.EmailTokenProcessor;
import kr.flab.ottsharing.user.domain.event.UserRegistered;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class UserEventHandler {

    private final EmailTokenProcessor emailTokenProcessor;

    public UserEventHandler(EmailTokenProcessor emailTokenProcessor) {
        this.emailTokenProcessor = emailTokenProcessor;
    }

    @Async
    @TransactionalEventListener
    public void handle(UserRegistered event) {
        emailTokenProcessor.execute(event.getEmail());
    }
}


