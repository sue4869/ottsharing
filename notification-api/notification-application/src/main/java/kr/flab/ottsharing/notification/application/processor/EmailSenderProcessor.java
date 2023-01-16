package kr.flab.ottsharing.notification.application.processor;

import kr.flab.ottsharing.notification.domain.NotificationList;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailSenderProcessor {

    private final JavaMailSender javaMailSender;

    public EmailSenderProcessor(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void send(NotificationList notificationList) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,false,"UTF-8");
            helper.setTo(notificationList.getRecevier());
            helper.setSubject(notificationList.getPurpose());
            helper.setText(notificationList.getMessage(),true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
