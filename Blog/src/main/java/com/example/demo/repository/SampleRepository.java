package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.SampleEntity;

@Repository
@Transactional
public interface SampleRepository extends JpaRepository<SampleEntity, Long>{

}
