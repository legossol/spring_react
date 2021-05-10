package shop.legossol.api.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import shop.legossol.api.common.service.AbstractService;
import shop.legossol.api.security.doamin.SecurityProvider;
import shop.legossol.api.security.exception.SecurityRuntimeException;
import shop.legossol.api.user.domain.UserVo;
import shop.legossol.api.user.domain.Role;
import shop.legossol.api.user.domain.UserDto;
import shop.legossol.api.user.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final SecurityProvider securityProvider;
    private final AuthenticationManager authenticationManager;

    private final ModelMapper modelMapper;

    @Override
    public String signup(UserVo member) {
        // TODO Auto-generated method stub
        if (!repo.existsByUsername(member.getUsername())) {
            member.setPassword(passwordEncoder.encode(member.getPassword()));
            List<Role> list = new ArrayList<>();
            list.add(Role.USER);
            member.setRoles(list);
            repo.save(member);
            return securityProvider.createToken(member.getUsername(), member.getRoles());
        } else {
            throw new SecurityRuntimeException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public UserDto signin(UserVo member) {
        // TODO Auto-generated method stub
        try {

            UserVo loginedMember = repo.signin(member.getUsername(), member.getPassword());
            UserDto memberDto = modelMapper.map(member, UserDto.class);
            String token = securityProvider.createToken(member.getUsername(),
                    repo.findByUsername(member.getUsername()).getRoles());
            log.info(":::::::::::::::ISSUED TOKEN::::::::::::::::", token);
            memberDto.setToken(token);
            return memberDto;
        } catch (AuthenticationException e) {
            throw new SecurityRuntimeException("Invalid Username / Password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
