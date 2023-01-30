package com.test.dev.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.test.dev.board.dto.BoardDTO;
import com.test.dev.board.dto.CategoryDTO;
import com.test.dev.page.dto.SearchDTO;

@Mapper
public interface BoardDAO {
	
	//게시물 목록
	public List<BoardDTO> selectBoard(SearchDTO params) throws Exception;
	//게시물 전체 수
	public int count(SearchDTO params) throws Exception;
	//게시물 상세
	public BoardDTO selectBoardDetail(String bnum) throws Exception;
	//게시물 조회수
	public void readCnt(String bnum) throws Exception;
	//게시물 등록
	public void insertBoard(BoardDTO baordDTO) throws Exception;
	//게시물 수정
	public void boardUpdate(BoardDTO baordDTO) throws Exception;
	//게시물 삭제
	public void boardDelete(String bnum) throws Exception;
	//카테고리
	public List<CategoryDTO> selectCt() throws Exception;
	//게시물 파일 목록
	public List<String> selectBoardFile(String bnum) throws Exception;
	//게시물 파일 등록
	public void insertBoardFile(Map<String, Object> map) throws Exception;
}
