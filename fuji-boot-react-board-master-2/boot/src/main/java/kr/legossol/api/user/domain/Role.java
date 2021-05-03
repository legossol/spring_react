package kr.legossol.api.user.domain;

import java.util.Arrays;

import com.amazonaws.services.codestar.model.Code;

import org.springframework.context.annotation.Description;
import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor @Getter
public enum Role implements GrantedAuthority {
    ADMIN("ROLE_ADMIN", "관리자 권한"),
    USER("ROLE_USER", "사용자 권한"),
    UNKNOWN("ROLE_UNKNOWN", "알수없는 권한");
    
    private final String code;
    private final String Description;

    public static Role of(String code){
        return Arrays.stream(Role.values()).filter(i -> i.getCode().equals(code)).findAny().orElse(UNKNOWN);
    }
    
@Override
public String getAuthority() {
    // TODO Auto-generated method stub
    return name();
}}
