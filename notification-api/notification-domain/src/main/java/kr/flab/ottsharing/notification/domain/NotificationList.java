package kr.flab.ottsharing.notification.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "notification_list")
public class NotificationList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recevier;
    private String purpose;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;
    @CreationTimestamp
    private Instant createdAt;

    protected NotificationList() {

    }

    public NotificationList(Long id, String recevier, String purpose, String message, Instant createdAt) {
        this.id = 0L;
        this.recevier = recevier;
        this.purpose = purpose;
        this.message = message;
        this.createdAt = createdAt;
    }

    public String getRecevier() {
        return recevier;
    }

    public String getPurpose() {
        return purpose;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getMessage() {
        return message;
    }
}
