package com.mulcam.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/misc")
public class MiscController {
	private String[] questions = {"사과", "배", "Orange", "Banana", "수영", "등산"};
	private int[] points = {10, 3, 9, 2, 1, 11};
	
	@GetMapping("/mbti")
	public String mbtiForm(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		String num_ = req.getParameter("num");
		int num = (num_ == null || num_.equals("")) ? 0 : Integer.parseInt(num_);
		
		int score = 0;
		if (num == 0)
			session.setAttribute("score", 1);
		if (num == 3) {
			score = (Integer) session.getAttribute("score");
			model.addAttribute("score", score);
			return "misc/result";
		} else {
			model.addAttribute("question1", questions[num * 2]);
			model.addAttribute("question2", questions[num * 2 + 1]);	
			model.addAttribute("point1", points[num * 2]);
			model.addAttribute("point2", points[num * 2 + 1]);
			model.addAttribute("num", num+1);
			return "misc/mbti";
		}
	}
	
	@PostMapping("/mbti")
	public String mbti(HttpServletRequest req) {
		int point = Integer.parseInt(req.getParameter("point"));
		int num = Integer.parseInt(req.getParameter("num"));
		HttpSession session = req.getSession();
		int score = (Integer) session.getAttribute("score");
		session.setAttribute("score", score+point);
		return "redirect:/misc/mbti?num=" + num;
	}
}
