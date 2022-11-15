package kr.flab.ottsharing.supports;

import kr.flab.common.ottsharing.error.DomainException;
import kr.flab.common.ottsharing.response.CommonApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerCollection {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DomainException.class)
    public CommonApiResponse DomainExceptionHandler(DomainException exception) {

        return CommonApiResponse.fail(exception.getErrorCode().name(),exception.getMessage());
    }
}
