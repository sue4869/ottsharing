package kr.flab.ottsharing.user.infrastructure.event;

import kr.flab.ottsharing.user.application.processor.EmailValidCheckTokenCreateProcessor;
import kr.flab.ottsharing.user.domain.event.UserRegistered;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class UserEventHandler {

    private final EmailValidCheckTokenCreateProcessor emailTokenCreateProcessor;
    private static final Logger log = LoggerFactory.getLogger(UserEventHandler.class);

    public UserEventHandler(EmailValidCheckTokenCreateProcessor emailTokenCreateProcessor) {
        this.emailTokenCreateProcessor = emailTokenCreateProcessor;
    }

    @Async("asyncTask")
    @TransactionalEventListener
    public void handle(UserRegistered event) {
        emailTokenCreateProcessor.execute(event.getEmail());
    }
}


