package shop.jinwookoh.api.security.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    // public static final 401_ERROR = "blah blah";
    AUTHENTICATION_FAILED(401, "AUTH_001", "AUTHENTICATION_FAILED"), LOGIN_FAILED(401, "AUTH_002", "LOGIN_FAILED"),
    ACCESS_DENIED(401, "AUTH_003", "ACCESS_FAILED"), TOKE_GENERATION_FAILED(500, "AUTH_004", "TOKE_GENERATION_FAILED");

    private final int status;
    private final String code;
    private final String message;

    // requiredArgsConstructor가 밑을 해결 해줌 ;

    // ErrorCode(final int status, final String code, final String message) {
    // this.status = status;
    // this.code = code;
    // this.message = message;
    // }
}
