package com.example.demo.domain;

import java.sql.Date;

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
@Table(name = "userEntity")
@SequenceGenerator(name = "user_id_seq")
@Data
@NoArgsConstructor
public class UserEntity {
	@Id
	@Column
	private String userId;
	
	private String password;
	
	private String userName;
	
	@Column
	private Date birthday;
	
	private int age;
	
	private boolean marriage;
	
	

}
