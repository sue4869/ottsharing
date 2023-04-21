package kr.flab.ottsharing.notification.domain.repository;

import kr.flab.ottsharing.notification.domain.NotificationList;

public interface NotificationListRepository {
    void save(NotificationList notificationList);
}
