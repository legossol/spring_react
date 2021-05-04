package kr.legossol.api.user.service;

import kr.legossol.api.user.domain.UserDto;

public interface UserService {

   String signup(UserDto user);
   String signin(UserDto user);
     
    
}
