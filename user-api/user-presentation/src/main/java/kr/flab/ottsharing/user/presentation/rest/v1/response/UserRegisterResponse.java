package kr.flab.ottsharing.user.presentation.rest.v1.response;

public class UserRegisterResponse {
    String email;

    public UserRegisterResponse(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
