package com.test.dev.comments.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.dev.comments.dto.CommentDTO;

@Mapper
public interface CommentDAO{
	public void commentAdd(CommentDTO commentDTO) throws Exception;
	public List<CommentDTO> commentSelect(int bnum) throws Exception;
	public void commentDelete(int comment_num) throws Exception;
	public void commentBoardDelete(int bnum) throws Exception;
}
