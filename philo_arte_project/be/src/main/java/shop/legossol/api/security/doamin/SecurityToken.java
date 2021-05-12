package shop.jinwookoh.api.security.doamin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.java.Log;

@Log
public class SecurityToken {
    private final String token;
    private final String key;

    public SecurityToken(String token, String key) {
        this.token = createToken();
        this.key = key;
    }

    private int tokenExpiraitonMsec = 18000000;

    private static final String AUTHORITIES_KEY = "role";

    public String createToken() {
        try {
            Map<String, Object> headers = new HashMap<>();
            headers.put("alg", "HS256");
            headers.put("typ", "JWT");
            Map<String, Object> payloads = new HashMap<>();
            payloads.put("data", "My First JWT");
            long expirationTime = 1000 * 60L * 60L * 2L; // 토큰 유효 시간 2시간
            Date ext = new Date();
            ext.setTime(ext.getTime() + expirationTime);
            // Jwts j = new JWts(getName() + .......) 와 같다
            return Jwts.builder().setHeader(headers).setClaims(payloads).setSubject("user").setExpiration(ext)
                    .signWith(SignatureAlgorithm.HS256, key.getBytes()).compact();
        } catch (SecurityException e) {
            log.info("Invalid JWT Signature");

        } catch (MalformedJwtException e) {
            log.info("Invalid JWT Token");

        } catch (ExpiredJwtException e) {
            log.info("Expired JWT Token");

        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Signature");

        } catch (IllegalArgumentException e) {
            log.info("JWT tokens compact of handler are invalid");

        }
        // 일부러 널을 준다 캐치 5개 에러 말고 다른것이 나올때 널 포인트 익셉션 주는게 더 낫다. (보안이 뚫리는 것보단)
        return null;

    }
}
