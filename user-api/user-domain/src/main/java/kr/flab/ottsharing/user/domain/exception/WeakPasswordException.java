package kr.flab.ottsharing.user.domain.exception;

import kr.flab.common.ottsharing.error.ErrorCode;
import kr.flab.common.ottsharing.error.DomainException;

public class WeakPasswordException extends DomainException {

    public WeakPasswordException() {
        super(ErrorCode.WEAK_PASSWORD);
    }

    public WeakPasswordException(String message, ErrorCode errorCode) {
        super(message, ErrorCode.WEAK_PASSWORD);
    }
}
