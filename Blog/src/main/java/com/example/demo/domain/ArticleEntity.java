package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "articleEntity")
@SequenceGenerator(name = "articles_id_seq")
@Data
@NoArgsConstructor
public class ArticleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "articles_id_seq")
	@Column
	private long id;
	
	@Column(length = 50, nullable = false)
	private String title;
	
	@Column(length = 200, nullable = false)
	private String text;
}
