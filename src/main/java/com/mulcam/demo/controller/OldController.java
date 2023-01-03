package com.mulcam.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.demo.entity.Chart;
import com.mulcam.demo.entity.Book;
import com.mulcam.demo.service.Old;

@Controller
@RequestMapping("/old")
public class OldController {

	@GetMapping("/interpark")
	public String interpark(Model model) throws IOException {
		List<Book> list = Old.bestSeller();
		model.addAttribute("bookList", list);
		return "crawling/interpark";
	}
	
	@GetMapping("/genie")
	public String genie(Model model) throws IOException {
		List<Chart> list = Old.genieChart();
		model.addAttribute("songList", list);
		return "crawling/genie2";
	}
	
}
