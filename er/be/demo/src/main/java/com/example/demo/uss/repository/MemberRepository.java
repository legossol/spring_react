package com.example.demo.uss.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.uss.domain.MemberVo;
import com.example.demo.uss.domain.MemberVo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

interface MemberCustomRepository {

    @Query(value = "SELECT * FROM members  WHERE username= :username AND password= :password", nativeQuery = true)
    MemberVo signin(@Param("username") String username, @Param("password") String password);
}

@Repository
public interface MemberRepository extends JpaRepository<MemberVo, Long>, MemberCustomRepository {
    boolean existsByUsername(String username);
    // Optional<MemberVo> findbyUsername(String username);
    MemberVo findByUsername(String username);

}
