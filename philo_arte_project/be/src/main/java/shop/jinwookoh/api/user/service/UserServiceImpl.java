package shop.jinwookoh.api.user.service;

import java.util.ArrayList;
import java.util.List;

import shop.jinwookoh.api.security.doamin.SecurityProvider;
import shop.jinwookoh.api.security.exception.SecurityRuntimeException;
import shop.jinwookoh.api.user.domain.UserVo;
import shop.jinwookoh.api.user.domain.Role;
import shop.jinwookoh.api.user.domain.UserDto;
import shop.jinwookoh.api.user.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SecurityProvider provider;
    private final AuthenticationManager manager;
    private final ModelMapper modelMapper;

    @Override
    public String signup(UserVo user) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            user.setRoles(list);
            userRepository.save(user);
            return provider.createToken(user.getUsername(), user.getRoles());
        } else {
            throw new SecurityRuntimeException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    @Override
    public UserDto signin(UserVo user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            log.info(" :::::::::: 암호와된 비밀번호 :::::::::: ", user.getPassword());
            UserVo loginedUser = userRepository.signin(user.getUsername(), user.getPassword());
            UserDto userDto = modelMapper.map(user, UserDto.class);
            String token = provider.createToken(user.getUsername(),
                    userRepository.findByUsername(user.getUsername()).getRoles());
            log.info(" :::::::::: ISSUED TOKEN :::::::::: ", token);
            userDto.setToken(token);
            return userDto;
        } catch (Exception e) {
            throw new SecurityRuntimeException("Invalid Username / Password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public List<UserVo> findAll() {
        // repo.findAll().stream().map(user -> modelMapper.map(user,
        // UserDTO.class)).collect(Collectors.toList())
        return userRepository.findAll();
    }
}