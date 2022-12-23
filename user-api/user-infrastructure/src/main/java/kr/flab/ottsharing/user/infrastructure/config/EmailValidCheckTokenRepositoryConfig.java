package kr.flab.ottsharing.user.infrastructure.config;

import kr.flab.ottsharing.user.domain.repository.EmailValidCheckTokenRepository;
import kr.flab.ottsharing.user.infrastructure.repository.EmailValidTokenRepositoryAdaptor;
import kr.flab.ottsharing.user.infrastructure.repository.jpa.EmailValidCheckTokenJpaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "kr.flab.ottsharing.user.infrastructure.repository.jpa")
@EntityScan(basePackages = "kr.flab.ottsharing.user.domain")
public class EmailValidCheckTokenRepositoryConfig {

    @Bean
    public EmailValidCheckTokenRepository emailTokenRepository(EmailValidCheckTokenJpaRepository emailTokenJpaRepository) {
        return new EmailValidTokenRepositoryAdaptor(emailTokenJpaRepository);
    }

}


