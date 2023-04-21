package kr.flab.ottsharing.notification.infrastructure.repository.jpa;

import kr.flab.ottsharing.notification.domain.NotificationList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationListJpaRepository extends JpaRepository<NotificationList,Long> {
}
