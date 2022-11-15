package kr.flab.ottsharing.user.infrastructure.config;

import kr.flab.ottsharing.user.domain.repository.UserV1Repository;
import kr.flab.ottsharing.user.infrastructure.config.repository.memory.UserV1JpaRepository;
import kr.flab.ottsharing.user.infrastructure.config.repository.UserV1RepositoryAdaptor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "kr.flab.ottsharing.user.infrastructure.config.repository.memory")
@EntityScan(basePackages = "kr.flab.ottsharing.user.domain")
public class UserRepositoryConfig {

    @Bean
    public UserV1Repository userV1Repository(UserV1JpaRepository userV1JpaRepository) {
        return new UserV1RepositoryAdaptor(userV1JpaRepository);
    }
}