package kr.flab.ottsharing.notification.infrastructure.repository;

import kr.flab.ottsharing.notification.domain.NotificationList;
import kr.flab.ottsharing.notification.domain.repository.NotificationListRepository;
import kr.flab.ottsharing.notification.infrastructure.repository.jpa.NotificationListJpaRepository;

public class NotificationListRepositoryAdaptor implements NotificationListRepository {

    private final NotificationListJpaRepository notificationListJpaRepository;

    public NotificationListRepositoryAdaptor(NotificationListJpaRepository notificationListJpaRepository) {
        this.notificationListJpaRepository = notificationListJpaRepository;
    }

    @Override
    public void save(NotificationList notificationList) {
        notificationListJpaRepository.save(notificationList);
    }
}
