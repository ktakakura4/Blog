package com.example.demo.controller;

import com.example.demo.service.ArticleService;
import com.example.demo.domain.ArticleEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestBody;


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

	@GetMapping("/post")
	public String getArticlePost(Model model) {
		model.addAttribute("contents", "article/post :: post_contents");
		return "article/layout.html";
	}

	@PostMapping("/articlelist")
	public String postArticleP(@ModelAttribute("artricleEntity") ArticleEntity articleEntity, Model model) {
		List<ArticleEntity> articleList = articleService.findAll();
		model.addAttribute("articleList", articleList);

		articleService.save(articleEntity);

		model.addAttribute("contents", "article/list :: list_contents");
		return "redirect:/articlelist";
	}

	@GetMapping("article/detail/{id}")
	public String getDetail(@PathVariable Long id, Model model) {

		Optional<ArticleEntity> articleEntity = articleService.findOne(id);
		model.addAttribute("article", articleEntity);

		model.addAttribute("contents", "article/detail :: detail_contents");
		return "article/layout.html";
	}

	@GetMapping("article/update/{id}")
	public String getUpdate(@PathVariable Long id, Model model) {

		Optional<ArticleEntity> articleEntity = articleService.findOne(id);
		model.addAttribute("article", articleEntity);

		model.addAttribute("contents", "article/update :: update_contents");
		return "article/layout.html";
	}

	@PutMapping("articleedit/{id}")
	public String postEdit(@PathVariable Long id, @ModelAttribute ArticleEntity articleEntity, Model model){

		articleEntity.setId(id);
		articleService.save(articleEntity);
		model.addAttribute("contents", "article/list :: list_contents");
		return "redirect:/articlelist";
	}
	



	@PostMapping("article/{id}")
	public String delete(@PathVariable Long id){
		articleService.delete(id);
		return "redirect:/articlelist";
	}
	
	
}
