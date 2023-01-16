package kr.flab.ottsharing.user.domain;

import kr.flab.common.ottsharing.domain.AggregateRoot;
import kr.flab.ottsharing.user.domain.event.UserEmailVerified;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
public class UserV1 extends AggregateRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    @Embedded
    private Email email;
    @Embedded
    private Password password;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant updatedAt;

    protected UserV1() {

    }

    public UserV1(Long id,String userName, String email, String password, Instant createdAt, Instant updatedAt) {
        this.id = Objects.requireNonNullElse(id, 0L);
        this.userName = userName;
        this.password = new Password(password);
        this.email = new Email(email);
    }

    private void verifyEmail() {

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

    public String getUserName() {
        return userName;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}

