package kr.flab.ottsharing.user.presentation.rest.v1.exception;

import kr.flab.common.ottsharing.response.CommonApiResponse;
import kr.flab.ottsharing.user.domain.exception.DuplicateEmailException;
import kr.flab.ottsharing.user.domain.exception.EmailTokenException;
import kr.flab.ottsharing.user.domain.exception.InvalidEmailException;
import kr.flab.ottsharing.user.domain.exception.WeakPasswordException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserExceptionHandler {

    @ExceptionHandler(DuplicateEmailException.class)
    public CommonApiResponse<Object> DuplicateEmailHandler(DuplicateEmailException exception) {
        return CommonApiResponse.fail(exception.getErrorCode().name(),exception.getMessage());
    }

    @ExceptionHandler(InvalidEmailException.class)
    public CommonApiResponse<Object> InvalidEmailExceptionHandler(InvalidEmailException exception) {

        return CommonApiResponse.fail(exception.getErrorCode().name(),exception.getMessage());
    }

    @ExceptionHandler(WeakPasswordException.class)
    public CommonApiResponse<Object> WeakPasswordExceptionHandler(WeakPasswordException exception) {

        return CommonApiResponse.fail(exception.getErrorCode().name(),exception.getMessage());
    }

    @ExceptionHandler(EmailTokenException.class)
    public CommonApiResponse<Object> EmailTokenExceptionHandler(EmailTokenException exception) {
        return CommonApiResponse.fail(exception.getErrorCode().name(),exception.getMessage());
    }
}


