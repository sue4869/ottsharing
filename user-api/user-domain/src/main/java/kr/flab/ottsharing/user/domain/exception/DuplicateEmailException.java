package kr.flab.ottsharing.user.domain.exception;

import kr.flab.common.ottsharing.error.ErrorCode;
import kr.flab.common.ottsharing.error.DomainException;

public class DuplicateEmailException extends DomainException {

    public DuplicateEmailException() {
        super(ErrorCode.DUPLICATED_EMAIL);
    }

    public DuplicateEmailException(String message, ErrorCode errorCode) {
        super(message, ErrorCode.DUPLICATED_EMAIL);
    }
}
