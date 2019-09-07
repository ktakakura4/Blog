package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.ArticleEntity;
import com.example.demo.repository.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public List<ArticleEntity> findAll() {
		return articleRepository.findAll();
	}
	
	public Optional<ArticleEntity> findOne(Long id) {
		return articleRepository.findById(id);
	}
	
	public ArticleEntity save(ArticleEntity articleEntity) {
		return articleRepository.save(articleEntity);
	}
	
	public void delete(Long id) {
		articleRepository.deleteById(id);
	}

}
