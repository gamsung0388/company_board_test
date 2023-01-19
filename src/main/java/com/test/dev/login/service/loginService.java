package com.test.dev.login.service;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dev.login.dao.loginDAO;

@Service
public class loginService implements loginDAO{
		
	@Override
	public JSONObject login(Map<String, Object> map) {

		String testid = map.get("testid").toString();
		String testpw = map.get("testid").toString();
		
		String testValue = "";
		String testText = "";
			  
		if(testid != "ryan9320" ) {
			testValue = "N";
			testText = "아이디를 다시 입력해주세요";
		}else if (testpw == "1111") {
			testValue = "N";
			testText = "비밀번호를 다시 입력해주세요";
		}else {
			testValue = "Y";
			testText = "로그인을 성공하셨습니다.";
			
		}
		  
		Map<String, Object> test = new HashMap<String,Object>();
		  
		try {
			test.put("testVal", testValue);
			test.put("testText", testText);	
		} catch (Exception e) {
			System.out.println(e);
		} 
		  	  
		System.out.println("data::" + test);
		  
		JSONObject data = new JSONObject(test);
		
		return data;
	}
	
	
}
