package com.test.dev.login.dao;

import org.apache.ibatis.annotations.Mapper;

import com.test.dev.member.dto.MemberDTO;

@Mapper
public interface LoginDAO {
	public MemberDTO login(String userId);
}
