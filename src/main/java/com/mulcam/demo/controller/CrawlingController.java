package com.mulcam.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mulcam.demo.entity.Genie;
import com.mulcam.demo.entity.Interpark;
import com.mulcam.demo.service.Crawling;

@Controller
@RequestMapping("/crawling")
public class CrawlingController {

	@GetMapping("/interpark")
	public String interpark(Model model) throws IOException {
		List<Interpark> list = Crawling.bestSeller();
		model.addAttribute("bookList", list);
		return "crawling/interpark";
	}
	
	@GetMapping("/genie")
	public String genie(Model model) throws IOException {
		List<Genie> list = Crawling.genieChart();
		model.addAttribute("songList", list);
		return "crawling/genie2";
	}
	
}
