package kr.flab.ottsharing.notification.domain;

import java.time.Instant;

public class ReadUserModel {

    private String userName;
    private String email;
    private Instant createdAt;

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
