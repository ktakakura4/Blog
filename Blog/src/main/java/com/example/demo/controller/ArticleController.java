package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.ArticleService;
import com.example.demo.domain.ArticleEntity;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping
	public String index(Model model) {
		List<ArticleEntity> articleEntities = articleService.findAll();
		model.addAttribute("article", articleEntities);
		return "article/index";
	}
	
	@GetMapping("new")
	public String newArticleEntity(Model model) {
		return "article/new";
	}
	
	@GetMapping("{id}")
	public void show(@PathVariable Long id, Model model) {
		Optional<ArticleEntity> articleEntity = articleService.findOne(id);
	}

}
