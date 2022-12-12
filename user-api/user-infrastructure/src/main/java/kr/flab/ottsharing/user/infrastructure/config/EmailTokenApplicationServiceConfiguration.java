package kr.flab.ottsharing.user.infrastructure.config;

import kr.flab.common.ottsharing.domain.EventPublisher;
import kr.flab.ottsharing.user.application.processor.EmailTokenProcessor;
import kr.flab.ottsharing.user.domain.TokenGenerator;
import kr.flab.ottsharing.user.domain.repository.EmailTokenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailTokenApplicationServiceConfiguration {

    @Bean
    public EmailTokenProcessor emailTokenProcessor(EmailTokenRepository emailTokenRepository, EventPublisher eventPublisher, TokenGenerator tokenGenerator) {
        return new EmailTokenProcessor(emailTokenRepository, eventPublisher, tokenGenerator);
    }
}


