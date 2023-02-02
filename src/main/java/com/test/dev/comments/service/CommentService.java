package com.test.dev.comments.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dev.comments.dao.CommentDAO;
import com.test.dev.comments.dto.CommentDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentService {
	
	@Autowired
	private CommentDAO commentDAO;
	
	//댓글 목록
	public List<CommentDTO> commentSelect(int board_num){
		
		List<CommentDTO> clist = new ArrayList<>();
		List<CommentDTO> alist = new ArrayList<>();
		List<CommentDTO> aalist = new ArrayList<>();
		
		log.info("1111:",board_num);
		
		try {
			
			clist = commentDAO.commentSelect(board_num);
			
			for(int i = 0;i<clist.size(); i++) {
				
				CommentDTO cdata = clist.get(i);
				System.out.println("cdata: "+cdata);
				alist = commentDAO.answerSelect(cdata);
				
					for(int j=0;j<alist.size();j++) {
						CommentDTO adata = alist.get(j);
						
						System.out.println("aadata: "+adata);
						aalist = commentDAO.answerSelect(adata);						
						
						cdata.setAnswerList(aalist);						
					}
				
				cdata.setAnswerList(alist);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clist;
	}
		
	//댓글 등록
	public String comment_add(CommentDTO commentDTO,HttpSession session) {
		try {
			
			String userId = (String)session.getAttribute("userid");
			commentDTO.setComment_user_id(userId);
			commentDAO.commentAdd(commentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "Y";
	}
	
	//답글 등록
	public String answer_add(CommentDTO commentDTO,HttpSession session) {
		
		String userId = (String)session.getAttribute("userid");
		
		try {
			commentDTO.setComment_user_id(userId);
			
//			int comment_order = commentDTO.getComment_order();
			int comment_order = commentDAO.comment_order_select(commentDTO);	
			CommentDTO cdto = commentDTO;
			cdto.setComment_order(comment_order);
			
			System.out.println("##############cdto: "+cdto);
			
			commentDAO.comment_order_update(cdto);
			
			int comment_class = commentDTO.getComment_class();
			commentDTO.setComment_class(comment_class+1);
			commentDTO.setComment_order(comment_order+1);
						
			commentDAO.answerAdd(commentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Y";
		
	}
	
	
	//댓글 삭제
	public String commentDelete(int comment_num) {
	
		try {
			commentDAO.commentDelete(comment_num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Y";
	}
	
	//댓글 게시글 삭제시 삭제
	public void commentBoardDelete(int bnum) {
		try {
			commentDAO.commentBoardDelete(bnum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
