package kr.flab.ottsharing.user.presentation.rest.v1.request;

import kr.flab.ottsharing.user.application.processor.UserCreateProcessor;

public class UserCreateRequest {

    private final String email;
    private final String password;

    public UserCreateRequest(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserCreateProcessor.Command toCommand() {
        return new UserCreateProcessor.Command(
                this.getEmail(),
                this.getPassword()
        );
    }
}