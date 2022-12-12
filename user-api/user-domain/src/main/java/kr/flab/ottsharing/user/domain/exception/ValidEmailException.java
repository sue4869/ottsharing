package kr.flab.ottsharing.user.domain.exception;

import kr.flab.common.ottsharing.error.DomainException;
import kr.flab.common.ottsharing.error.ErrorCode;

public class ValidEmailException extends DomainException {
    public ValidEmailException() {
        super(ErrorCode.VALID_EMAIL);
    }

    public ValidEmailException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}


