package kr.flab.ottsharing.user.application.processor;

import kr.flab.common.ottsharing.domain.EventPublisher;
import kr.flab.ottsharing.user.domain.EmailToken;
import kr.flab.ottsharing.user.domain.exception.EmailTokenException;
import kr.flab.ottsharing.user.domain.repository.EmailTokenRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

public class EmailTokenProcessor {

    private final EmailTokenRepository emailTokenRepository;
    private final EventPublisher eventPublisher;
    private static final Logger log = LoggerFactory.getLogger(EmailTokenProcessor.class);

    public EmailTokenProcessor(EmailTokenRepository emailTokenRepository, EventPublisher eventPublisher) {
        this.emailTokenRepository = emailTokenRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public void execute(String email) {
        try {
            EmailToken emailToken = new EmailToken(
                    null,
                    email
            );
            emailTokenRepository.save(emailToken);
            emailToken.occurredEvents().forEach(eventPublisher::publish);
        }
        catch(Exception e) {
            log.error("토큰생성에 문제가 생겼습니다.",e, "토큰생성이 안된 이메일:"+ email);
            throw new EmailTokenException();
        }
    }
}