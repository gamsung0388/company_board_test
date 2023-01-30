package com.test.dev.login.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.dev.login.service.loginService;
import com.test.dev.member.dto.MemberDTO;

@Controller 
public class loginController{
	
	@Autowired
	loginService loginService;
	
	@GetMapping("/loginpage")
	public String loginpage(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		System.out.println("session: "+session);	
		
		return "/login/login";
    }
	
	@ResponseBody
	@PostMapping("login")
	public Map<String, Object> login(MemberDTO memberDTO,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Map<String, Object> map = loginService.login(memberDTO, session);
		
		return map;
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		 if (session != null) {
            session.invalidate();
        }
		 
		return "redirect:/loginpage";
	}
			
}

