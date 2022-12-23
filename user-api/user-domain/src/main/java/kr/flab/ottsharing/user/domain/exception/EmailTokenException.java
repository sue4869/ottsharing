package kr.flab.ottsharing.user.domain.exception;

import kr.flab.common.ottsharing.error.DomainException;
import kr.flab.common.ottsharing.error.ErrorCode;

public class EmailTokenException extends DomainException {

    public EmailTokenException() {
        super(ErrorCode.EMAIL_TOKEN_ERROR);
    }

    public EmailTokenException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }

}


