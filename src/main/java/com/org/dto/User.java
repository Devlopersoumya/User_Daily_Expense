package com.org.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class User {

	@Id
	@Column(name="user_id")
	@GeneratedValue
	private int id;
	
	@Column(name="user_name")
	private String name;
	
	@Column(name="user_age")
	private int age;
	
	@Column(name="user_mobile")
	private long mobile;
	
	@Column(name="user_email")
	private String email;
	
	@Column(name="user_pwd")
	private String password;
	
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Month>months;
	
	
//	@OneToMany(mappedBy = "user")
//	private List<Expenses> expenses;
	
}
