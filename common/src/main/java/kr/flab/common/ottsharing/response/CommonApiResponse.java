package kr.flab.common.ottsharing.response;

import kr.flab.common.ottsharing.error.ErrorCode;

public class CommonApiResponse<T> {

    private final boolean success;
    private final T body;
    private final Error error;

    public CommonApiResponse(boolean success, T body, Error error) {
        this.success = success;
        this.body = body;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getBody() {
        return body;
    }

    public Error getError() {
        return error;
    }

    public static <T> CommonApiResponse<T> success(T data) {
        return new CommonApiResponse<>(true,data,null);
    }

    public static CommonApiResponse<Object> fail(Error error) {
        return new CommonApiResponse<>(false, null, error);
    }

    public static CommonApiResponse<Object> fail(ErrorCode errorCode) {
        return new CommonApiResponse<>(false, null, new Error(errorCode.name(), errorCode.getMessage()));
    }

    public static CommonApiResponse<Object> fail(String code, String message) {
        return new CommonApiResponse<>(false, null, new Error(code,message));
    }

    public static final class Error {
        private final String code;
        private final String message;

        Error(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }


}

