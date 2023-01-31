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
        int comment_num = commentDTO.getComent_num();
        log.info("comment_num: ",comment_num);
        
        successYN = commentService.commentDelete(comment_num);
        
        int bnum = commentDTO.getBoard_num();
		List<CommentDTO> list = commentService.commentSelect(bnum);
        
		map.put("successYN", successYN);
		map.put("commentList",list);
		
		System.out.println("map:" +map);
		
		return map;
	}
	
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
		
		String userId = (String)session.getAttribute("userid");
		commentDTO.setComment_user_id(userId);
		
		commentService.comment_add(commentDTO);		
		
		int bnum = commentDTO.getBoard_num();
		List<CommentDTO> list = commentService.commentSelect(bnum);
		
		successYN = "Y";
		map.put("successYN",successYN);
		map.put("commentList",list);
		
		System.out.println("map:" +map);
		
		return map;
	}
	
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
		
        int bnum = commentDTO.getBoard_num();
        List<CommentDTO> list = commentService.commentSelect(bnum);
        
        map.put("commentList",list);
        map.put("successYN",successYN);
        
		return map;
		
	}
}
