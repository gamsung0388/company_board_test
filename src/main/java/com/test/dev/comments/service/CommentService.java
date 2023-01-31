package com.test.dev.comments.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dev.comments.controllor.CommentController;
import com.test.dev.comments.dao.CommentDAO;
import com.test.dev.comments.dto.CommentDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentService {
	
	@Autowired
	private CommentDAO commentDAO;
	
	public void comment_add(CommentDTO commentDTO) {
		try {
			
			commentDTO.setComment_class(0);
			commentDTO.setComment_order(0);
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
//		System.out.println("111111111");
//		for (int i=0;i<list.size();i++) {
//			CommentDTO comment = list.get(i);
//			System.out.println(comment);	
//			
//			int commentNum = comment.getComent_num();
//			int groupNum = comment.getGroup_num();
//			
//			if(commentNum==groupNum) {
//				
//			}
//			
//		}
//		System.out.println("111111111");
		
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
	
	public void answerAdd(CommentDTO commentDTO) {
		
		try {
			commentDTO.setComment_class(1);
			commentDTO.setComment_order(1);
			commentDAO.answerAdd(commentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
}
