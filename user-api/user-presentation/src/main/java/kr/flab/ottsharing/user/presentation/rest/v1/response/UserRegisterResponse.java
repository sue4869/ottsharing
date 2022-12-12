package kr.flab.ottsharing.user.presentation.rest.v1.response;

import kr.flab.ottsharing.user.application.processor.response.EmailDTO;

public class UserRegisterResponse {

    EmailDTO email;

    public UserRegisterResponse(EmailDTO email) {
        this.email = email;
    }

    public EmailDTO getEmail() {
        return email;
    }
}


