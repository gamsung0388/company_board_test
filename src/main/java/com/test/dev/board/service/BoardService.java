package com.test.dev.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dev.board.dao.BoardDAO;
import com.test.dev.board.dao.FileDAO;
import com.test.dev.board.dto.BoardDTO;
import com.test.dev.board.dto.CategoryDTO;
import com.test.dev.page.controller.PageController;
import com.test.dev.page.dto.Pagination;
import com.test.dev.page.dto.SearchDTO;

@Service
public class BoardService {

	private static final Logger log = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private FileDAO fileDAO;

	//목록
	public Map<String, Object> selectBoard(SearchDTO params) throws Exception{
		
		Map<String, Object> map = new HashMap<>();
		
		int count = boardDAO.count(params);
		
		Pagination pagination = new Pagination(count, params);
		params.setPagination(pagination);
		
//		System.out.println("params: "+params);
		
		List<BoardDTO> list = boardDAO.selectBoard(params);
		
		map.put("list", list);
		map.put("pagination", params.getPagination());		
		
		return map;
	}
	
	//상세
	public BoardDTO selectBoard(String bnum) throws Exception{
		BoardDTO boardDetail = boardDAO.selectBoardDetail(bnum);
		return boardDetail;
	}
	
	public void readCnt(String bnum) throws Exception{
		boardDAO.readCnt(bnum);
	}
	
	//등록	
	public String insertBoard(BoardDTO boardDTO) throws Exception{
				
		boardDAO.insertBoard(boardDTO);
		return "Y";
	}
	
	//수정
	public String boardUpdate(BoardDTO baordDTO) throws Exception{
		boardDAO.boardUpdate(baordDTO);
		
		return "Y";
	}
	
	//삭제
	public void boardDelete(String bnum) throws Exception{
		boardDAO.boardDelete(bnum);
	}
	
	//카테고리
	public List<CategoryDTO> selectCt() throws Exception{
		List<CategoryDTO> ctlist = boardDAO.selectCt();
		return ctlist;
	}
	
	public void deleteBoardFile(String fileIds) {
		log.info("fileIds: "+fileIds);
		
		String[] fileIdArray = fileIds.split(",");
		
		for(int i=0;i<fileIdArray.length;i++) {
			String fileId =fileIdArray[i];
			log.info("fileId: "+fileId);
			int cnt =fileDAO.deleteFile(fileId);
			log.info("fileDelteCnt: "+cnt);
		}
	}	
	//게시물 파일 등록
	public void insertBoardFile(BoardDTO boardDTO) throws Exception{
				
		if(boardDTO.getFileIdxs() != null) {
			//파일 등록
			String fileIdxs = boardDTO.getFileIdxs().replace("[", "").replace("]", "");
			log.info("fileIdxs:{}",fileIdxs);
			log.info("board_num:{}",boardDTO.getBoard_num());
			String[] fileIdxArray = fileIdxs.split(",");
			
			Map<String, Object> map = new HashMap<>();
			
			for(int i=0; i<fileIdxArray.length; i++) {
				
				map.put("bnum",boardDTO.getBoard_num());
				map.put("fileId",fileIdxArray[i]);
				
				boardDAO.insertBoardFile(map);
			}
		}
	}
	
	//게시판 파일 select
	public List<String> selectBoardFile(String bnum) throws Exception{
		List<String> list = boardDAO.selectBoardFile(bnum);		
		return list;
	}
	
	
}
