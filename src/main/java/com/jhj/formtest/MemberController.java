package com.jhj.formtest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
