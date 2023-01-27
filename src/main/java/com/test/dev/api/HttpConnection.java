package com.test.dev.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.dev.page.controller.PageController;

import antlr.collections.List;
@Controller
public class HttpConnection {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@GetMapping("/api")
	@ResponseBody
	public Map<String, Object> getJson(@RequestParam Map<String, Object> param) {
		
		String result = "";
		logger.info("param={}"+param);
		
		Map<String, Object> map = new HashMap<>();
		
		String urlParam = "?";
		urlParam+= "ServiceKey="+param.get("ServiceKey");
		urlParam+= "&pageNo="+param.get("pageNo");
		urlParam+= "&numOfRows="+param.get("numOfRows");
		urlParam+= "&dataType="+param.get("dataType");
		urlParam+= "&code1="+param.get("code1");
		urlParam+= "&code2="+param.get("code2");
		urlParam+= "&time="+param.get("time");
		
		String test = "";
		try {
			URL url = new URL("http://apis.data.go.kr/1360000/WthrChartInfoService/getAuxillaryChart"+urlParam);
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setRequestProperty("Content-type", "application/json");
			//서버로부터 데이터 읽어오기
			BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
			result = bf.readLine();
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(result.toString());	
			JSONObject response = (JSONObject)jsonObject.get("response");			
			JSONObject body =  (JSONObject)response.get("body");
			JSONObject items =  (JSONObject) body.get("items");
			JSONArray arr = (JSONArray)items.get("item");
			
			System.out.println(arr.toString());
		}catch(Exception e){
			System.out.println(e);
		}
		
		logger.info("result:"+test);
		
		
		return map;
		
		
		
	}
	
}
