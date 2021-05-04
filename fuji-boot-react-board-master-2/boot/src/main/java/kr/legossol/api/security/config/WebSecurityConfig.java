package kr.legossol.api.security.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration 
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    private final SecurityProvider provider;
    @Bean
    passwordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }//modelMapper hashMap 2 Json
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable(); //csrf불가능하게 만들기
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
            .antMatchers("/users/signin").permitAll()
            .antMatchers("/users/signup").permitAll()
            .antMatchers("/h2-console/**/**").permitAll()
            .anyRequest().authenticated();
        http.exceptionHandling().accessDeniedPage("/login");
        http.apply(new SecurityConfig(provider));
    }
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring()
            .antMatchers(HttpMethod.OPTIONS, "*/**")
            .antMatchers("/","/h2-console/**");
    }
}
