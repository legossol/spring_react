package shop.jinwookoh.api.security.aop;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.jinwookoh.api.security.doamin.SecurityProvider;
import shop.jinwookoh.api.security.exception.SecurityRuntimeException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.RequiredArgsConstructor;

// 리퀘스트 당 1회 검사  리액트  -> 리퀘스트  -> 서버 

@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {
    private final SecurityProvider provider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String token = provider.resolveToken(request);
        try {
            if (token != null && provider.validateToken(token)) {
                Authentication auth = provider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);

            }
        } catch (SecurityRuntimeException e) {
            SecurityContextHolder.clearContext();
            response.sendError(e.getHttpStatus().value(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        filterChain.doFilter(request, response);

    }
}
