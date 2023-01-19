package com.test.dev.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.test.dev.board.dto.BoardDTO;
import com.test.dev.board.dto.CategoryDTO;

@Mapper
public interface BoardDAO {
	public List<BoardDTO> selectBoard() throws Exception;
	public BoardDTO selectBoardDetail(String bnum) throws Exception;
	public void insertBoard(BoardDTO baordDTO) throws Exception;
	public void boardUpdate(BoardDTO baordDTO) throws Exception;
	public void boardDelete(String bnum) throws Exception;
	public List<CategoryDTO> selectCt() throws Exception;
	public List<String> selectBoardFile(String bnum) throws Exception;
	public void insertBoardFile(Map<String, Object> map) throws Exception;
}
