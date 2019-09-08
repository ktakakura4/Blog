package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ListController {
	
	@GetMapping("/list")
	public String getList(Model model) {
		model.addAttribute("contents", "article/list :: list_contents");
		return "article/layout";
	}
	
	@PostMapping("/logout")
	public String postLogout() {
		return "login/login";
	}
}
