package kr.flab.ottsharing.user.domain.exception;

import kr.flab.common.ottsharing.error.DomainException;
import kr.flab.common.ottsharing.error.ErrorCode;

public class AlreadyValidEmailException extends DomainException {
    public AlreadyValidEmailException() {
        super(ErrorCode.VALID_EMAIL);
    }

    public AlreadyValidEmailException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}


