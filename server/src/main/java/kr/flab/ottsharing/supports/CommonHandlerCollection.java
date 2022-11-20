package kr.flab.ottsharing.supports;

import kr.flab.common.ottsharing.error.ErrorCode;
import kr.flab.common.ottsharing.response.CommonApiResponse;
import kr.flab.ottsharing.user.domain.exception.DuplicateEmailException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class CommonHandlerCollection {

    @ResponseStatus
    @ExceptionHandler(Exception.class)
    public CommonApiResponse<Object> onException(Exception e) {
        return CommonApiResponse.fail(ErrorCode.SYSTEM_ERROR);
    }
}

