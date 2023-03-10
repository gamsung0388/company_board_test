package com.test.dev.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dev.member.dao.MemberDAO;
import com.test.dev.member.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	public String idOverChk(String userId) throws Exception {
		
		int IdCnt = memberDAO.idOverChk(userId);
		String chkyn;
		
		if(IdCnt > 0) {
			chkyn = "N";
		}else {
			chkyn = "Y";
		}
		return chkyn;
	}	

	public String memberJoin(MemberDTO memberDTO) throws Exception {
		
		memberDAO.memberJoin(memberDTO);
		
		return "Y";
	}
	
	public MemberDTO memberOne(String userId) throws Exception{
	
		MemberDTO memberDTO = memberDAO.memberOne(userId);
		
		return memberDTO;
	}
	public List<MemberDTO> memberSelect(String userId) throws Exception{
		
		List<MemberDTO> memberDTO = memberDAO.memberSelect(userId);
		
		return memberDTO;
	}
	
	public String memberUpdate(MemberDTO memberDTO) throws Exception {
		
		memberDAO.memberUpdate(memberDTO);
		
		return "Y";
	}

}
