package kr.flab.ottsharing.user.infrastructure.config;

import kr.flab.ottsharing.user.domain.repository.EmailTokenRepository;
import kr.flab.ottsharing.user.infrastructure.config.repository.EmailTokenRepositoryAdaptor;
import kr.flab.ottsharing.user.infrastructure.config.repository.jpa.EmailTokenJpaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "kr.flab.ottsharing.user.infrastructure.config.repository.jpa")
@EntityScan(basePackages = "kr.flab.ottsharing.user.domain")
public class EmailTokenRepositoryConfig {

    @Bean
    public EmailTokenRepository emailTokenRepository(EmailTokenJpaRepository emailTokenJpaRepository) {
        return new EmailTokenRepositoryAdaptor(emailTokenJpaRepository);
    }

}


