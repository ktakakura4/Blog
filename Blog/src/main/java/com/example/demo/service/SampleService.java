package com.example.demo.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.SampleEntity;
import com.example.demo.repository.SampleRepository;

@Service
@Transactional
public class SampleService {
	
	@Autowired
	SampleRepository sampleRepository;
	
	public SampleEntity save(SampleEntity sampleEntity) {
		return sampleRepository.save(sampleEntity);
	}
	
	public List<SampleEntity> findAll() {
		return sampleRepository.findAll();
	}
	
	public SampleEntity findByid(Long id) {
		return sampleRepository.findById(id).get();
	}
	}

