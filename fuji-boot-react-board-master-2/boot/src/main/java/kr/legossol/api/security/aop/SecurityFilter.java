package kr.legossol.api.security.aop;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import kr.legossol.api.security.domain.SecurityPrivider;
import kr.legossol.api.security.exception.SecurityRuntimeException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {
    private SecurityProvider provider;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = provider.resolveToken(request);
        try{
            if(token != null && provider.validateToken(token)){
                Authentication auth = provider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }catch (SecurityRuntimeException e){
            SecurityContextHolder.clearContext();
            response.sendError(e.getHttpStatus().value(), e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
        filterChain.doFilter(request, response);
    }
}