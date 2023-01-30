package com.test.dev.page.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.dev.board.service.BoardService;
import com.test.dev.member.dto.MemberDTO;
import com.test.dev.member.service.MemberService;
import com.test.dev.page.dto.SearchDTO;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("memberJoinPage")
	public String memberJoinpage() {
		return "/member/memberjoin";
	}
	
	@GetMapping("/")
	public String main(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession(false);
        
		System.out.println(session);
		System.out.println(request.isRequestedSessionIdValid());
		
		if (session == null || !request.isRequestedSessionIdValid()) {
            return "redirect:/loginpage";
        }
        
        return "/main/main";
	}
	
	/**
	 * 페이지 이동
	 * @param pageId
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:8080") // 추가
	@GetMapping("/pageGo")
	public String pageGo(HttpServletRequest request,@RequestParam String pageId){
		
		HttpSession session = request.getSession(false);
        if (session == null || !request.isRequestedSessionIdValid()) {
            return "redirect:/loginpage";
        }
		
		return "redirect:/board/"+pageId;
	}
	
	//게시물페이지로
	@GetMapping("/board/board")
	public ModelAndView board(HttpServletRequest request, @ModelAttribute("params") SearchDTO params, Model model)throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession(false);
		if (session == null || !request.isRequestedSessionIdValid()) {
            System.out.println();
			mv.setViewName("redirect:/loginpage");
			
			return mv;
        }
		
		
		Map<String, Object> map = boardService.selectBoard(params);
		
		mv.addObject("boardList",map.get("list"));
		mv.addObject("pagination",map.get("pagination"));
		mv.setViewName("/board/board");
		
		return mv;
	}
	//이벤트 페이지로
	@GetMapping("/board/event")
	public String event(HttpServletRequest request)throws Exception{
		
		HttpSession session = request.getSession(false);
        if (session == null || !request.isRequestedSessionIdValid()) {
            return "redirect:/loginpage";
        }
		
		return "/board/event";
	}
	
	//공지사항,문의사항 페이지로
	@GetMapping("/board/question")
	public String question(HttpServletRequest request)throws Exception{
		
		HttpSession session = request.getSession(false);
        if (session == null || !request.isRequestedSessionIdValid()) {
            return "redirect:/loginpage";
        }
		
		return "/board/question";
	}
	
	//공지사항,문의사항 페이지로
	@GetMapping("/board/travelApi")
	public String travelApi(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession(false);
        if (session == null || !request.isRequestedSessionIdValid()) {
            return "redirect:/loginpage";
        }
		
		return "/board/travelApi";
	}
	
	@GetMapping("/setting")
	public ModelAndView memberUpdate(HttpServletRequest request) throws Exception{
		
		ModelAndView mv = new ModelAndView(); 
				
		HttpSession session = request.getSession(false);
		if (session == null || !request.isRequestedSessionIdValid()) {
        	mv.setViewName("redirect:/loginpage");
			return mv;
        }
		
		String userId = (String)session.getAttribute("userid");
		
		MemberDTO memberDTO = memberService.memberOne(userId);
		
		mv.addObject("memberDTO",memberDTO);
		mv.setViewName("/login/setting");
		
		return mv;
	}
	@GetMapping("/memberManage")
	public ModelAndView memberManage(HttpServletRequest request)throws Exception{
		
		ModelAndView mv = new ModelAndView(); 
		
		HttpSession session = request.getSession(false);
		if (session == null || !request.isRequestedSessionIdValid()) {
        	mv.setViewName("redirect:/loginpage");
			return mv;
        }
		
		String userId = (String)session.getAttribute("userid");
		
		List<MemberDTO> memberList = memberService.memberSelect(userId);
		
		mv.addObject("memberList",memberList);
		mv.setViewName("/member/memberManage");
		
		return mv;
	}
	@GetMapping("/memberSetting")
	public ModelAndView memberSetting(@RequestParam String userId) throws Exception{
		
		ModelAndView mv = new ModelAndView(); 
		
		MemberDTO memberDTO = memberService.memberOne(userId);
		
		mv.addObject("memberDTO",memberDTO);
		mv.setViewName("/member/memberSetting");
		
		return mv;
	}
	
	
}
