package kr.flab.ottsharing.user.domain.exception;

import kr.flab.common.ottsharing.error.ErrorCode;
import kr.flab.common.ottsharing.error.DomainException;

public class InvalidEmailException extends DomainException {

    public InvalidEmailException() {
        super(ErrorCode.INVALID_EMAIL);
    }

    public InvalidEmailException(String message, ErrorCode errorCode) {
        super(message, ErrorCode.INVALID_EMAIL);
    }
}


