package kr.legossol.api.user.service;

import kr.legossol.api.user.domain.UserDto;
import kr.legossol.api.user.domain.UserVo;

public interface UserService {

   String signup(UserVo user);
   UserDto signin(UserVo user);
     
    
}
