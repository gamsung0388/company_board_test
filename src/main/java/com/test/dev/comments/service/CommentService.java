package com.test.dev.comments.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dev.comments.dao.CommentDAO;
import com.test.dev.comments.dto.CommentDTO;

@Service
public class CommentService {
	
	@Autowired
	private CommentDAO commentDAO;
	
	public void comment_add(CommentDTO commentDTO) {
		try {
			commentDAO.commentAdd(commentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<CommentDTO> commentSelect(int bnum){
		
		List<CommentDTO> list = new ArrayList<>();
		
		try {
			list = commentDAO.commentSelect(bnum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public String commentDelete(int comment_num) {
	
		try {
			commentDAO.commentDelete(comment_num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Y";
	}
	
	public void commentBoardDelete(int bnum) {
		try {
			commentDAO.commentBoardDelete(bnum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
