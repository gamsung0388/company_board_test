package com.test.dev.login.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.dev.login.service.loginService;

@Controller 
public class loginController{
	
	@GetMapping("/login")
	public String test(){
      return "/main/login";
    }
  
	@RequestMapping(value="/totallogin", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(@RequestParam Map<String,Object> param) throws Exception{
		loginService loginService = null;
	  
		Map<String, Object> map = new HashMap<String, Object>();
		map = loginService.login(param);
	  	
		return map;
	}
}

