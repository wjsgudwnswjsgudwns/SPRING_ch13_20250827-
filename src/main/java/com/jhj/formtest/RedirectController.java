package com.jhj.formtest;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedirectController {

	@RequestMapping(value = "/studentInput")
	public String studentInput() {
		
		return "studentInput";
	}
	
	@RequestMapping(value = "/studentCheck")
	public String studentCheck(@RequestParam("sid") String sid, Model model,HttpServletResponse response) {
		
		if(sid.endsWith("tiger")) { // 아이디가 tiger이면 학생으로 간주
			return "redirect:studentGood"; 
		// redirect: -> 다시 studentGood으로 요청, studentGood.jsp로 가는게 아님
			//return "studentGood";
		} else {
			return "redirect:studentNg";
			//return "studentNg";
		}
		
	}
	
	
	@RequestMapping(value = "/studentGood")
	public String studentGood(Model model) {
		model.addAttribute("sid", "tiger");
		
		return "studentGood";
	}
	
	@RequestMapping(value = "/studentNg")
	public String studentNg(Model model) {
		model.addAttribute("sid", "tiger");
		
		return "studentNg";
	}
	
}
