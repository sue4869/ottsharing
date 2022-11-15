package kr.flab.ottsharing.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "kr.flab.ottsharing.repository")
@EntityScan(basePackages = "kr.flab.ottsharing.entity")
public class RepositoryConfig {
}
