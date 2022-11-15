package kr.flab.common.ottsharing.error;

public enum ErrorCode {

    DUPLICATED_EMAIL(400,"중복된 이메일입니다."),
    WEAK_PASSWORD(400,"취약한 비밀번호입니다."),
    INVALID_EMAIL(400,"유효하지 않은 이메일입니다.");

    private final int status;
    private final String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
