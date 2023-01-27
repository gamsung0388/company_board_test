package com.test.dev.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.test.dev.member.dto.MemberDTO;

@Mapper
public interface MemberDAO {
	public int idOverChk(String userId) throws Exception;	
	public void memberJoin(MemberDTO memberDTO) throws Exception;
	public MemberDTO memberSelect(String userId);
	public void memberUpdate(MemberDTO memberDTO) throws Exception;
}
