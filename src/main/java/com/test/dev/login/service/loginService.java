package com.test.dev.login.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dev.login.dao.LoginDAO;
import com.test.dev.member.dto.MemberDTO;

@Service
public class loginService{
		
	@Autowired
	LoginDAO loginDAO;

	public Map<String, Object> login(MemberDTO memberDTO, HttpSession session) {

		String testid = memberDTO.getUser_id();
		String testpw = memberDTO.getUser_pw();
		
		MemberDTO md = loginDAO.login(testid);
		
		String msg = "";
		String code = "N";
		System.out.println();
		if(md == null) {
			msg+= "아이디가 맞지 않습니다";			
		}else if(!testpw.equals(md.getUser_pw())) {
			
			msg+= "비밀번호가 맞지않습니다.";
		}else {
			msg+= "로그인이 성공했습니다.";
			session.setAttribute("userid", md.getUser_id());
			code = "Y";
		}
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("msg", msg);
		map.put("code", code);
		
		return map;
	}
	
	
}
