package kr.flab.ottsharing.user.infrastructure.config;

import kr.flab.common.ottsharing.domain.EventPublisher;
import kr.flab.ottsharing.user.application.processor.EmailValidCheckTokenProcessor;
import kr.flab.ottsharing.user.domain.TokenGenerator;
import kr.flab.ottsharing.user.domain.repository.EmailValidCheckTokenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailValidCheckTokenApplicationServiceConfiguration {

    @Bean
    public EmailValidCheckTokenProcessor emailTokenProcessor(EmailValidCheckTokenRepository emailTokenRepository, EventPublisher eventPublisher, TokenGenerator tokenGenerator) {
        return new EmailValidCheckTokenProcessor(emailTokenRepository, eventPublisher, tokenGenerator);
    }
}



