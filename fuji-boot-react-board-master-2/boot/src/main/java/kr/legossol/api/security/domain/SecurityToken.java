package kr.legossol.api.security.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
@Log
public class SecurityToken {
    private final String token;
    private final String key;
    private int tokenExpirationMsec = 1800000;//만료시간 30분
    private static final String AUTHORITIES_KEY = "role";

    public SecurityToken(String key){
        this.token = createToken();
        this.key = key;

    }
    public String createToken(){
        Map<String, Object> headers = new HashMap<>();
        Map<String, Object> payloads = new HashMap<>();
        headers.put("alg", "HS256");
        headers.put("typ", "JWT");

        payloads.put("dadta", "My First JWT");
        Long exirartionTime = 1000* 60L*60L*2L; // 토큰 유효시간 2시간
        Date ext = new Date();
        ext.setTime(ext.getTime()+exirartionTime);
        return Jwts
        .builder()
        .setHeader(headers)
        .setClaims(payloads)
        .setSubject("user")
        .setExpiration(ext)
        .signWith(SignatureAlgorithm.HS256, key.getBytes())
        .compact();
    }catch(SecurityException e){log.info("Invalid JWT Signature");
    }catch(MalformedJwtException e){log.info("Invalid JWT Token");
    }catch(ExpiredJwtException e){log.info("Expiration JWT token");
    }catch(UnsupportedJwtException e){log.info("Unsupported JWT Signature");
    }catch(IllegalArgumentException e){log.info("JWT token compact of handler are invalid.");
    }return null;
    
}
