package kr.flab.ottsharing.user.domain;

import kr.flab.common.ottsharing.domain.AggregateRoot;
import kr.flab.ottsharing.user.domain.event.EmailTokenGenerated;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name ="emailToken")
public class EmailValiedCheckToken extends AggregateRoot {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String emailCheckToken;
    private Instant expireDate;
    @CreationTimestamp
    private Instant createdAt;

    @Transient
    private static final Long MAX_EXPIRE_MINUTES_TIME = 5L;

    protected EmailValiedCheckToken() {

    }

    public EmailValiedCheckToken(Long id, String email, String token) {
        if(id == null) {
            this.id = 0L;
        } else {
            this.id = id;
        }
        this.email = email;
        this.emailCheckToken = token;
        generateEmailCheckTokenEvent();
    }

    private void generateEmailCheckTokenEvent() {
        this.expireDate = Instant.now().plus(MAX_EXPIRE_MINUTES_TIME, ChronoUnit.MINUTES);
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


