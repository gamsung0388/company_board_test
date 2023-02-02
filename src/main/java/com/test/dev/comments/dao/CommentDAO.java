package com.test.dev.comments.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.dev.comments.dto.CommentDTO;

@Mapper
public interface CommentDAO{
	public void commentAdd(CommentDTO commentDTO) throws Exception;
	public List<CommentDTO> commentSelect(int board_num) throws Exception;
	public void commentDelete(int coment_num) throws Exception;
	public void commentBoardDelete(int bnum) throws Exception;
	
	public int comment_order_select(CommentDTO commentDTO) throws Exception;
	public void comment_order_update(CommentDTO commentDTO) throws Exception;
	public void answerAdd(CommentDTO commentDTO) throws Exception;
	public List<CommentDTO> answerSelect(CommentDTO commentDTO) throws Exception;
}
