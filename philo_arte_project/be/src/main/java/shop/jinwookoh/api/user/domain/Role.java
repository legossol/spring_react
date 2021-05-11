package shop.jinwookoh.api.user.domain;

import java.util.Arrays;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role implements GrantedAuthority {
    // 쓰는 이유 : 상수는 상수풀에 저장 되어 계속 유지 그러나 이넘은 이넘으로 감싸져서 이넘을 가비지 컬렉터가 지워줌 그래서 빠르고 자원효율이
    // 높다;
    ADMIN("ROLE_ADMIN", "관리자 권한"), USER("ROLE_USER", "사용자 권한"), UNKNOWN("ROLE_UNKNOWN", "알수 없는 사용자");

    private final String code;
    private final String description;

    // 이넘은 눈에 안보이지만 배열화 되어 있다. -> 순서 안주면 0,1,2,3 ....으로 내부적으로 인덱싱처리됨.
    // role은 내부적으로 배열화 되어서 가지고 있다. -> 한유저는 여러개의 롤을 가지고 있음 그래서 배열화 -> 코드가 없으면 언노운으로
    // 반환해라
    public static Role of(String code) {
        return Arrays.stream(Role.values()).filter(i -> i.getCode().equals(code)).findAny().orElse(UNKNOWN);
    }

    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return name();
    }

}
