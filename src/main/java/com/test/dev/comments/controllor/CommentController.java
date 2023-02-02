package com.test.dev.comments.controllor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.dev.board.controller.BoardContoroller;
import com.test.dev.comments.dto.CommentDTO;
import com.test.dev.comments.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommentController {
	
	@Autowired
	public CommentService commentService;
	
	//댓글 목록
	@ResponseBody
	@GetMapping("/comment_select")
	public Map<String, Object> comment_select(CommentDTO commentDTO,HttpServletRequest request){
		
		
		String successYN = "";
		Map<String, Object> map = new HashMap<>();
		
		HttpSession session = request.getSession(false);
        if (session == null || !request.isRequestedSessionIdValid()) {
        	successYN = "L";
        	map.put("successYN", successYN);
        	map.put("url", "/loginpage");
        	return map;
        }
        		
        List<CommentDTO> list = commentService.commentSelect(commentDTO.getBoard_num());	
        successYN = "Y";
		map.put("successYN",successYN);
		map.put("commentList", list);
        
		return map;
	}
	
	//댓글 등록
	@ResponseBody
	@GetMapping("/comment_add")
	public Map<String, Object> comment_add(CommentDTO commentDTO,HttpServletRequest request) {
		
		String successYN = "";
		Map<String, Object> map = new HashMap<>();
		
		HttpSession session = request.getSession(false);
        if (session == null || !request.isRequestedSessionIdValid()) {
        	successYN = "L";
        	map.put("successYN", successYN);
        	map.put("url", "/loginpage");
        	return map;
        }
		
		successYN = commentService.comment_add(commentDTO,session);		
		map.put("successYN",successYN);
				
		return map;
	}
	
	//답글 등록
	@ResponseBody
	@GetMapping("/answer_add")
	public Map<String, Object> answer_add(CommentDTO commentDTO,HttpServletRequest request){
		String successYN = "";
		Map<String, Object> map = new HashMap<>();
		
		HttpSession session = request.getSession(false);
        if (session == null || !request.isRequestedSessionIdValid()) {
        	successYN = "L";
        	map.put("successYN", successYN);
        	map.put("url", "/loginpage");
        	return map;
        }
		
        successYN = commentService.answer_add(commentDTO,session);		
		map.put("successYN",successYN);
				
		return map;
        
	}
	
	//댓글 삭제
	@ResponseBody
	@GetMapping("/commentDelete")
	public Map<String, Object> commentDelete(CommentDTO commentDTO, HttpServletRequest request){
		
		log.info("commentDTOdd={}",commentDTO);
		
		String successYN = "";
		Map<String, Object> map = new HashMap<>();
		
		HttpSession session = request.getSession(false);
        if (session == null || !request.isRequestedSessionIdValid()) {
        	successYN = "L";        	
        	map.put("successYN", successYN);
        	map.put("url", "/loginpage");
            return map;
        }
        
        int coment_num = commentDTO.getComent_num();
        successYN = commentService.commentDelete(coment_num);
        map.put("successYN", successYN);
		
		return map;
	}
	
	
	

}
