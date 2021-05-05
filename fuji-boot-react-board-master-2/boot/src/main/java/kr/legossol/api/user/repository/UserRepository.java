package kr.legossol.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.legossol.api.user.domain.UserVo;

public interface UserRepository extends JpaRepository<UserVo, Long>{
    boolean existsByUsername(String username);
    UserVo findByUsername(String username);
    @Query("sselect u from Uservo where u.username = :username and u.password = :password")
    UserVo signin(@Param("username")String username ,@Param("password")String password);
}
