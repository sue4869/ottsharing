package kr.flab.ottsharing.notification.infrastructure.event;

import kr.flab.ottsharing.notification.application.processor.EmailNotificationProcessor;
import kr.flab.ottsharing.notification.application.processor.EmailSenderProcessor;
import kr.flab.ottsharing.notification.domain.NotificationList;
import kr.flab.ottsharing.notification.domain.ReadUserModel;
import kr.flab.ottsharing.notification.domain.event.RegisteredUserEvent;
import kr.flab.ottsharing.notification.infrastructure.reader.MyBatisUserReader;
import org.springframework.context.event.EventListener;;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class NotificationEventHandler {

    private final EmailNotificationProcessor emailNotificationProcessor;
    private final MyBatisUserReader myBatisUserReader;
    private final EmailSenderProcessor emailSenderProcessor;

    public NotificationEventHandler(EmailNotificationProcessor emailValidCheckProcessor, MyBatisUserReader myBatisUserReader, EmailSenderProcessor emailSenderProcessor) {
        this.emailNotificationProcessor = emailValidCheckProcessor;
        this.myBatisUserReader = myBatisUserReader;
        this.emailSenderProcessor = emailSenderProcessor;
    }

    @EventListener
    @Transactional
    public void handle(RegisteredUserEvent event) {
        ReadUserModel userModel = myBatisUserReader.getUserByEmail(event.getEmail());
        NotificationList notificationList = emailNotificationProcessor.execute(event, userModel.getUserName());
        emailSenderProcessor.send(notificationList);
    }
}

