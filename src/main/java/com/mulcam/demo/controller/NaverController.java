package com.mulcam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/naver")
public class NaverController {

	@GetMapping("/staticMap")
	public String staticMap(Model model) {
		String url = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster";
		String accessId = "spyvtsexbi";
		String secretKey = "i0fuRdbOBhXv2B5TbJCwwvwo1pK0xnGLSZOAGe0c";
		model.addAttribute("url", url);
		model.addAttribute("accessId", accessId);
		model.addAttribute("secretKey", secretKey);
		return "naver/staticMap";
	}
}
