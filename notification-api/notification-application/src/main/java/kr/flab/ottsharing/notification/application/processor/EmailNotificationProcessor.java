package kr.flab.ottsharing.notification.application.processor;

import kr.flab.ottsharing.notification.domain.NotificationList;
import kr.flab.ottsharing.notification.domain.event.RegisteredUserEvent;
import kr.flab.ottsharing.notification.domain.repository.NotificationListRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmailNotificationProcessor {

    private final ThymeleafTemplateProcessor thymeleafTemplateProcessor;
    private final NotificationListRepository notificationListRepository;
    private final String host;

    public EmailNotificationProcessor(@Value("app.mail.host") String host, TemplateEngine templateEngine, ThymeleafTemplateProcessor thymeleafTemplateProcessor, NotificationListRepository notificationListRepository) {
        this.host = host;
        this.thymeleafTemplateProcessor = thymeleafTemplateProcessor;
        this.notificationListRepository = notificationListRepository;
    }

    public NotificationList execute(RegisteredUserEvent event, String userName) {
        Map<String,Object> variables = new HashMap<>();
        variables.put("username",userName);
        variables.put("linkName","이메일 인증");
        variables.put("message", "아래 링크를 클릭하면 ottsharing 서비스를 받을 수 있습니다");
        variables.put("link", "/api/v1/confirm?token=" + event.getEmailCheckToken()
                + "&email=" + event.getEmail());
        variables.put("host",host);

        String message = thymeleafTemplateProcessor.process("mail/registerLinkEmail", variables);
        NotificationList notificationList = new NotificationList(null, event.getEmail(), "계정확인메일",message, Instant.now());
        notificationListRepository.save(notificationList);

        return notificationList;
    }
}
