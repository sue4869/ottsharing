package kr.flab.ottsharing.user.domain;

import kr.flab.common.ottsharing.domain.AggregateRoot;
import kr.flab.ottsharing.user.domain.event.EmailTokenGenerated;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
public class EmailToken extends AggregateRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String emailCheckToken;
    private Instant expireDate;
    @CreationTimestamp
    private Instant createdAt;

    @Transient
    private static final Long MAX_EXPIRE_TIME = 5L;

    protected EmailToken() {

    }

    public EmailToken(Long id, String email) {
        if(id == null) {
            this.id = 0L;
        } else {
            this.id = id;
        }
        this.email = email;
        generateEmailCheckToken();
    }

    protected void generateEmailCheckToken() {
        this.emailCheckToken = UUID.randomUUID().toString();
        this.expireDate = Instant.now().plus(MAX_EXPIRE_TIME, ChronoUnit.MINUTES);
        raise(
                new EmailTokenGenerated(
                        this.id,
                        this.email,
                        this.emailCheckToken,
                        this.expireDate
                )
        );
    }
}
