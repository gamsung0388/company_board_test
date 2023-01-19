package com.test.dev.board.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.test.dev.board.dto.FileDTO;

@Mapper
public interface FileDAO {
	//파일등록
	public int insertFile(Map<String, Object> file);
	//파일 조회
	public FileDTO getFileInfo(String fileId);
	//해당 파일 삭제처리
	public int deleteFile(String fileId);
}
