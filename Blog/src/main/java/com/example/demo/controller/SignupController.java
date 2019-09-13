package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.domain.UserEntity;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {
	
	@Autowired
	UserService userService;
	
	private Map<String, String> radioMarriage;
	private Map<String, String> initRadioMarriage(){
		Map<String, String> radio = new LinkedHashMap<>();
		
		radio.put("married","true");
		radio.put("unmarried","false");
		
		return radio;
	}
	
	@GetMapping("/signup")
	public String getSignup(Model model) {
		
		radioMarriage = initRadioMarriage();
		model.addAttribute("radioMarriage", radioMarriage);
		
		return "login/signup";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute("userEntity") UserEntity userEntity, Model model) {
		List<UserEntity> userList = userService.findAll();
		model.addAttribute("userList", userList);

		userService.save(userEntity);
		return "redirect:/login";
	}
}
