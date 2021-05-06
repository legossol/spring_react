package com.example.demo.uss.service;

import java.util.List;

import com.example.demo.uss.domain.MemberVo;
import com.example.demo.uss.domain.MemberDto;
import com.example.demo.uss.domain.MemberVo;

public interface MemberService {
    String signup(MemberVo member);

    MemberDto signin(MemberVo member);

}
