package kr.legossol.api.security.aop;


import org.apache.http.HttpStatus;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.legossol.api.security.domain.Messenger;
import kr.legossol.api.security.exception.ErrorCode;
import kr.legossol.api.security.exception.LoginRuntimeException;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class SecurityExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Messenger> handleRuntimeException(RuntimeException e){
        log.info("handleRuntimeException", e);

        Messenger response = Messenger.builder()
                .code("test")
                .message(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(SecurityException.class)
    protected ResponseEntity<Messenger> handleCustomAuthenticationException(SecurityException e){
        log.info("handleCustomAuthenticationException", e);

        Messenger response = Messenger.builder()
                .code(ErrorCode.AUTHENTICATION_FAILED.getCode())
                .message(e.getMessage())
                .status(ErrorCode.AUTHENTICATION_FAILED.getStatus())
                .build();
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(LoginRuntimeException.class)
    protected ResponseEntity<Messenger> handleLoginFailedException(LoginRuntimeException e){
        log.info("handleLoginFailedException", e);

        Messenger response = Messenger.builder()
                .code(ErrorCode.LOGIN_FAILED.getCode())
                .message(e.getMessage())
                .status(ErrorCode.LOGIN_FAILED.getStatus())
                .build();
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<Messenger> handleBadCredentialsException(BadCredentialsException e){
        log.info("handleBadCredentialsException", e);

        Messenger response = Messenger.builder()
                .code(ErrorCode.LOGIN_FAILED.getCode())
                .message(e.getMessage())
                .status(ErrorCode.LOGIN_FAILED.getStatus())
                .build();
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<Messenger> handleAccessDeniedException(AccessDeniedException e){
        log.info("handleAccessDeniedException", e);

        Messenger response = Messenger.builder()
                .code(ErrorCode.ACCESS_DENIED.getCode())
                .message(ErrorCode.ACCESS_DENIED.getMessage())
                .status(ErrorCode.ACCESS_DENIED.getStatus())
                .build();
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(InsufficientAuthenticationException.class)
    protected ResponseEntity<Messenger> handleInsufficientAuthenticationException(AccessDeniedException e){
        log.info("handleInsufficientAuthenticationException", e);

        Messenger response = Messenger.builder()
                .code(ErrorCode.AUTHENTICATION_FAILED.getCode())
                .message(ErrorCode.AUTHENTICATION_FAILED.getMessage())
                .status(ErrorCode.AUTHENTICATION_FAILED.getStatus())
                .build();
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }


}