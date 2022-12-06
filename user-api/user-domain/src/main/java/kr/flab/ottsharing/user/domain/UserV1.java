package kr.flab.ottsharing.user.domain;

import kr.flab.common.ottsharing.domain.AggregateRoot;
import kr.flab.ottsharing.user.domain.event.UserEmailVerified;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class UserV1 extends AggregateRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Email email;
    @Embedded
    private Password password;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    protected UserV1() {

    }

    public UserV1(Long id, String email, String password, Instant createdAt, Instant updatedAt) {
        if(id == null) {
            this.id = 0L;
        } else {
            this.id = id;
        }
        this.password = new Password(password);
        this.email = new Email(email);
    }

    public void verifyEmail() {
        this.email.verify();
        raise(
                new UserEmailVerified(
                        this.id,
                        this.email.getEmail()
                )
        );
    }

    public Long getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}

