package kr.flab.ottsharing.notification.infrastructure.config;

import kr.flab.ottsharing.notification.domain.repository.NotificationListRepository;
import kr.flab.ottsharing.notification.infrastructure.repository.NotificationListRepositoryAdaptor;
import kr.flab.ottsharing.notification.infrastructure.repository.jpa.NotificationListJpaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "kr.flab.ottsharing.notification.infrastructure.repository.jpa")
@EntityScan(basePackages = "kr.flab.ottsharing.notification.domain")
public class NotificationListConfig {

    @Bean
    public NotificationListRepository notificationListRepository(NotificationListJpaRepository notificationListJpaRepository) {
        return new NotificationListRepositoryAdaptor(notificationListJpaRepository);
    }
}
