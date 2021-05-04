package kr.legossol.api.user.service;

import javax.security.sasl.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import kr.legossol.api.security.domain.SecurityProvider;

import jdk.internal.org.jline.utils.Log;
import kr.legossol.api.user.domain.UserDto;
import kr.legossol.api.user.domain.UserVo;
import kr.legossol.api.user.repository.UserRepository;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityProvider provider;
    private final AuthenticationManager manager;
    
    @Override
    public String signup(UserDto user) {
        if(!userRepository.existsByUsername(user.getUsername())){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return provider.createToken(user.getUsername(), user.getRoles());
        }else{
            throw new SecurityRuntimeException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


    @Override
    public String signin(UserDto user) {
        try{
            UserVo logineduser = userRepository.signin(user.getUsername(), user.getPassword());
            String token = providder.createToken(user.getUsername(), userRepository.findByUsername(user.getUsername()).getRoles())
            Log.info(":::::::ISSUED TOKEN :::::::,token");

        }catch(AuthenticationException e){
            throw new SecurityRuntimeException("UInvalidd Username / Password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        
    }

}
