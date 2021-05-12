package shop.jinwookoh.api.user.service;

import java.util.List;

import shop.jinwookoh.api.user.domain.UserVo;
import shop.jinwookoh.api.user.domain.UserDto;
import shop.jinwookoh.api.user.domain.UserVo;

public interface UserService {
    String signup(UserVo user);

    UserDto signin(UserVo user);

    List<UserVo> findAll();

}
