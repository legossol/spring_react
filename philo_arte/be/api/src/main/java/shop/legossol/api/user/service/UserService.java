package shop.legossol.api.user.service;

import java.util.List;

import shop.legossol.api.user.domain.UserVo;
import shop.legossol.api.user.domain.UserDto;

public interface UserService {
    String signup(UserVo member);

    UserDto signin(UserVo member);

}
