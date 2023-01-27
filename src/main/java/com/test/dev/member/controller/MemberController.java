package com.test.dev.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.dev.member.dto.MemberDTO;
import com.test.dev.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@ResponseBody
	@GetMapping("idOverChk")
	public String userIdOverChk(@RequestParam("userid") String userId) throws Exception {

		String idChkYn = memberService.idOverChk(userId);
		
		return idChkYn;
	}
	
	@ResponseBody
	@PostMapping("/memberJoin")
	public String memberJoin(MemberDTO memberDTO) throws Exception {

		String joinYn = memberService.memberJoin(memberDTO);
		
		if(joinYn!="Y") {
			joinYn = "N";
		}
		
		return joinYn;
	}
	
	@ResponseBody
	@PostMapping("/memberUpdate")
	public String memberUpdate(MemberDTO memberDTO) throws Exception {
		
		System.out.println("memberDTO: "+memberDTO);
		String UpdateYn = memberService.memberUpdate(memberDTO);
		
		if(UpdateYn!="Y") {
			UpdateYn = "N";
		}
		
		return UpdateYn;
	}
	
}
