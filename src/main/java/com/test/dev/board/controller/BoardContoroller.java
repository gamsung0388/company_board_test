package com.test.dev.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.dev.board.dto.BoardDTO;
import com.test.dev.board.dto.CategoryDTO;
import com.test.dev.board.service.BoardService;
import com.test.dev.comments.dto.CommentDTO;
import com.test.dev.comments.service.CommentService;
import com.test.dev.page.dto.SearchDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardContoroller {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private CommentService commentService;
		
	//게시물 목록
	@ResponseBody
	@GetMapping("/board/select")
	public Map<String, Object> boardSelect(HttpServletRequest request,@ModelAttribute("params") SearchDTO params) throws Exception{
		
		log.info("게시물 목록");
		
		Map<String, Object> map = new HashMap<>();
		HttpSession session = request.getSession(false);
		String successYN = "";
		
		if (session == null || !request.isRequestedSessionIdValid()) {
			
			successYN = "L";
        	map.put("successYN", successYN);
			map.put("url","/loginpage");
			
            return map;
        }		
		
		Map<String, Object> smap = boardService.selectBoard(params);
		
		successYN = "Y";
		
		map.put("successYN",successYN);
		map.put("boardList",smap.get("list"));
		map.put("pagination",smap.get("pagination"));
		
		return map;
	}
	
	
	//게시물 상세로
	@GetMapping("/board/detail")
	public ModelAndView board(String bnum,HttpServletRequest request)throws Exception{
		
		log.info("게시물 상세");
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession(false);
        
		if (session == null || !request.isRequestedSessionIdValid()) {
			mv.setViewName("redirect:/loginpage");
			
            return mv;
        }		
		
		boardService.readCnt(bnum);
		
		List<CommentDTO> clist = commentService.commentSelect(Integer.parseInt(bnum));
		
		BoardDTO boardDetail = boardService.selectBoard(bnum);
		List<String> list = boardService.selectBoardFile(bnum);
		
		mv.addObject("boardFilelist",list);
		mv.addObject("commentList",clist);
		mv.addObject("boardDetail",boardDetail);
		mv.setViewName("/board/detail");
		
		return mv;
	}
	
	//등록 페이지 이동
	@GetMapping("/board/insertpage")
	public ModelAndView boardInsertpage(HttpServletRequest request)throws Exception{
		
		log.info("게시물 등록 페이지 이동");
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession(false);
        if (session == null || !request.isRequestedSessionIdValid()) {
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
	public ModelAndView boardUpdatepage(String bnum,HttpServletRequest request)throws Exception{
		
		log.info("게시물 수정 페이지 이동");
		
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession(false);
        if (session == null || !request.isRequestedSessionIdValid()) {
        	mv.setViewName("redirect:/loginpage");
            return mv;
        }
		
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
	public Map<String, Object> boardInsert(BoardDTO boardDTO,HttpServletRequest request)throws Exception{
		
		log.info("게시물 등록");
		
		HttpSession session = request.getSession(false);
		
        String successYN = "";
		
        Map<String, Object> map = new HashMap<>();
        
        if (session == null || !request.isRequestedSessionIdValid()) {
        	successYN = "L";
        	
        	map.put("successYN", successYN);
        	map.put("url", "/loginpage");
        	
        	return map;
        }
        
        String userId = (String)session.getAttribute("userid");
		        
		boardDTO.setUser_id(userId);
		successYN = boardService.insertBoard(boardDTO);
		
		if(!boardDTO.getFileIdxs().isEmpty()) {
			boardService.insertBoardFile(boardDTO);
		}
		
		map.put("successYN", successYN);
		
		return map;
	}
	 
	//게시물 수정
	@ResponseBody
	@GetMapping("/board/update")
	public Map<String, Object> boardUpdate(BoardDTO boardDTO,HttpServletRequest request)throws Exception{
		
		log.info("게시물 수정");
		
		String successYN = "";
		
		Map<String, Object> map = new HashMap<>();
		
		HttpSession session = request.getSession(false);
        if (session == null || !request.isRequestedSessionIdValid()) {
        	successYN = "L";
        	
        	map.put("successYN", successYN);
        	map.put("url", "/loginpage");
        	
            return map;
        }
		
		successYN = boardService.boardUpdate(boardDTO);
		
		if(!boardDTO.getFileIdxs().isEmpty()) {
			log.info("boardUpdate2: " + boardDTO.getFileIdxs());
			boardService.insertBoardFile(boardDTO);	
		}
		if(boardDTO.getDelete_files()!=null) {
			boardService.deleteBoardFile(boardDTO.getDelete_files());
		}
		
		map.put("successYN", successYN);
		
		return map;
	}
	
	//게시물삭제
	@GetMapping("/board/delete")
	public String boardDelete(String bnum,HttpServletRequest request)throws Exception{
		
		log.info("게시물 삭제");
		
		HttpSession session = request.getSession(false);
        if (session == null || !request.isRequestedSessionIdValid()) {
        	
            return "redirect:/loginpage";
        }
		
		commentService.commentBoardDelete(Integer.parseInt(bnum));
		boardService.boardDelete(bnum);
		
		return "redirect:/board/board";
	}

	//게시물삭제
	@GetMapping("/board/alldelete")
	@ResponseBody
	public Map<String, Object> boardAllDelete(@RequestParam(value="chkArr[]") List<String> chkArr ,HttpServletRequest request)throws Exception{
		
		String successYN = "";
		Map<String, Object> map = new HashMap<>();
		
		HttpSession session = request.getSession(false);
        if (session == null || !request.isRequestedSessionIdValid()) {
        	successYN = "L";
        	
        	map.put("successYN", successYN);
        	map.put("url", "/loginpage");
        	
            return map;
        }
		
		log.info("게시물 전체 삭제");
		
		commentService.commentBoardAllDelete(chkArr);
		boardService.boardAllDelete(chkArr);
		
		successYN = "Y";
		map.put("successYN", successYN);
		
		return map;
	}
	
}
