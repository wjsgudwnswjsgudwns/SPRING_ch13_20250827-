package com.jhj.formtest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

	@RequestMapping(value = "/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value = "/login2")
	public String login2() {
		
		return "login2";
	}
	
	@RequestMapping(value = "/join")
	public String join() {
		
		return "join";
	}
	
	@RequestMapping(value = "/loginOk")
	public String loginOk(HttpServletRequest request, Model model, HttpSession session, HttpServletResponse response) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		model.addAttribute("inputId", mid);
		
		if(mid.equals("tiger") && mpw.equals("12345")) {
			session.setAttribute("sessionId", mid);
			return "loginOk";
		} else { // 로그인 실패
			return "loginFail";
		}
	}
	
	@RequestMapping(value = "/loginOk2")
	public String loginOk2(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw, Model model, HttpSession session, HttpServletResponse response) {
		//@RequestParam("mid") String mid
		//String mid = request.getParameter("mid");
		
		//@RequestParam("mpw") String mpw
		//String mpw = request.getParameter("mpw");
		
		model.addAttribute("inputId", mid);
		
		if(mid.equals("tiger") && mpw.equals("12345")) {
			session.setAttribute("sessionId", mid);
			return "loginOk";
		} else { // 로그인 실패
			return "loginFail";
		}
	}
	
	@RequestMapping(value = "/boardlist/{bnum}")
	public String boardlist(@PathVariable String bnum, Model model) { // 파라미터 이름없이 전달된 값 받아오기
		model.addAttribute("bnum", bnum);
		
		return "boardlist";
	}
	
	@RequestMapping(value = "/joinOk", method = RequestMethod.POST)
	//public String joinOk(HttpServletRequest request, Model model) {
	public String joinOk(MemberDto memberDto, Model model) {
	// MemberDto의 멤버 변수와 form의 파라미터 이름이 반드시 일치
		
		//String mid = request.getParameter("mid");
		//String mpw = request.getParameter("mpw");
		//String mname = request.getParameter("mname");
		//String mage = request.getParameter("mage");
		
		//MemberDto memberDto = new MemberDto(mid, mpw, mname, mage);
		model.addAttribute("memberDto", memberDto);
		
		return "joinOk";
	}
	
	@RequestMapping(value = "/joinOk", method = RequestMethod.GET)
	public String joinOk2(MemberDto memberDto, Model model) {
		
		model.addAttribute("memberDto", memberDto);
		
		return "joinOk";
	}
}
