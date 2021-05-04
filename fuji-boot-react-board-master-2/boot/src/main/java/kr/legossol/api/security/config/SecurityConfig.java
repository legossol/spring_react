package kr.legossol.api.security.config;

import kr.legossol.api.security.domain.SecurityPrivider;
import lombok.RequiredArgsConstructor;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@RequiredArgsConstructor
public class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain,HttpSecurity>{
    private SecurityPrivider provider;
    @Override
    public void configure(HttpSecurity http) throws Exception{
        SecurityFilter filter = new SecurityFilter(provider);
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.)
    }
}
