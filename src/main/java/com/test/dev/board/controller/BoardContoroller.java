package com.test.dev.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.dev.board.dto.BoardDTO;
import com.test.dev.board.dto.CategoryDTO;
import com.test.dev.board.service.BoardService;
import com.test.dev.page.controller.PageController;

@Controller
public class BoardContoroller {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private BoardService boardService;
	
	//게시물 상세로
	@GetMapping("/board/detail")
	public ModelAndView board(String bnum)throws Exception{
		
		ModelAndView mv = new ModelAndView();
		boardService.readCnt(bnum);
		
		BoardDTO boardDetail = boardService.selectBoard(bnum);
		List<String> list = boardService.selectBoardFile(bnum);
		
		mv.addObject("boardFilelist",list);
		mv.addObject("boardDetail",boardDetail);
		mv.setViewName("/board/detail");
		
		return mv;
	}
	
	//등록 페이지 이동
	@GetMapping("/board/insertpage")
	public ModelAndView boardInsertpage(HttpServletRequest request)throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession(false);
        if (session == null) {
        	mv.setViewName("redirect:/loginpage");
            return mv;
        }
		
		List<CategoryDTO> selectCt = boardService.selectCt();
		
		mv.addObject("selectCt",selectCt);
		mv.addObject("boardtype","insert");
		mv.setViewName("/board/insert");
		
		return mv;
	}
	
	//수정 페이지 이동
	@GetMapping("/board/updatepage")
	public ModelAndView boardUpdatepage(String bnum)throws Exception{
		
		ModelAndView mv = new ModelAndView();

		BoardDTO boardDetail = boardService.selectBoard(bnum);
		List<CategoryDTO> selectCt = boardService.selectCt();
		List<String> list = boardService.selectBoardFile(bnum);
		
		mv.addObject("boardFilelist",list);
		mv.addObject("selectCt",selectCt);
		mv.addObject("boardDetail",boardDetail);
		mv.addObject("boardtype","update");
		mv.setViewName("/board/insert");
		
		return mv;
	}
	
	//게시물 등록
	@ResponseBody
	@GetMapping("/board/insert")
	public String boardInsert(BoardDTO boardDTO,HttpSession session)throws Exception{
		
		boardDTO.setUser_id((String)session.getAttribute("userid"));
		String successYN = boardService.insertBoard(boardDTO);
		logger.info("insertBoard:" + boardDTO.toString());
		
		if(!boardDTO.getFileIdxs().isEmpty()) {
			boardService.insertBoardFile(boardDTO);
		}
		return successYN;
	}
	 
	//게시물 수정
	@ResponseBody
	@GetMapping("/board/update")
	public String boardUpdate(BoardDTO baordDTO)throws Exception{
		String successYN = boardService.boardUpdate(baordDTO);
		logger.info("boardUpdate1: " + baordDTO.toString());
		
		if(!baordDTO.getFileIdxs().isEmpty()) {
			logger.info("boardUpdate2: " + baordDTO.getFileIdxs());
			boardService.insertBoardFile(baordDTO);	
		}
		
		if(baordDTO.getDelete_files()!=null) {
			boardService.deleteBoardFile(baordDTO.getDelete_files());
		}
		
		return successYN;
	}
	
	//게시물삭제
	@GetMapping("/board/delete")
	public String boardDelete(String bnum)throws Exception{
		boardService.boardDelete(bnum);
		return "redirect:/board/board";
	}

}
