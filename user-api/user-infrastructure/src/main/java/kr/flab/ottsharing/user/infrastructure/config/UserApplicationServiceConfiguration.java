package kr.flab.ottsharing.user.infrastructure.config;

import kr.flab.common.ottsharing.domain.EventPublisher;
import kr.flab.ottsharing.user.application.processor.UserCreateProcessor;
import kr.flab.ottsharing.user.domain.repository.UserV1Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserApplicationServiceConfiguration {

    @Bean
    public UserCreateProcessor userCreateProcessor(UserV1Repository userV1Repository, EventPublisher eventPublisher) {
        return new UserCreateProcessor(userV1Repository, eventPublisher);
    }
}



