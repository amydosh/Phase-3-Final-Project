package com.amydosh.sportyshoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestingController {

	// This works! ResponseBody annotation allows text to return exactly to the controller
//	@RequestMapping(value="/testing")
//	@ResponseBody
//	public String index() {
//		return "this is a simple response body test";
//	}
	
	@RequestMapping(value="")
	public String index(Model model) {
		model.addAttribute("title", "My Cheeses");
		return "sportyshoes/index";
	}	
	
}
