package com.example.demo.controller;

import com.example.demo.service.ArticleService;
import com.example.demo.domain.ArticleEntity;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/articlelist")
	public String getArticleList(Model model) {
		List<ArticleEntity> articleList = articleService.findAll();
		model.addAttribute("articleList", articleList);
		model.addAttribute("contents", "article/list :: list_contents");
		return "article/layout.html";
	}
}
