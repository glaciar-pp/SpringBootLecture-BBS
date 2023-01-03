package com.mulcam.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/map")
public class MapController {

	@Value("${naver.accessId}")
	private String accessId;
	
	@Value("${naver.secretKey}")
	private String secretKey;
	
	@GetMapping("/staticMap")
	public String staticMap() {
		String url = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?w=300&h=300&center=127.1054221,37.3591614&level=16";
		url += "&X-NCP-APIGW-API-KEY-ID=" + accessId;
		url += "&X-NCP-APIGW-API-KEY=" + secretKey;
		
		return "map/staticForm";
	}
}
