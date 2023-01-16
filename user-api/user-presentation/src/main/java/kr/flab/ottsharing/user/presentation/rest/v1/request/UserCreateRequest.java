package kr.flab.ottsharing.user.presentation.rest.v1.request;

import kr.flab.ottsharing.user.application.processor.UserCreateProcessor;

public class UserCreateRequest {


    private final String email;
    private final String userName;
    private final String password;

    public UserCreateRequest(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    public UserCreateProcessor.Command toCommand() {
        return new UserCreateProcessor.Command(
                this.getEmail(),
                this.getUserName(),
                this.getPassword()
        );
    }
}

