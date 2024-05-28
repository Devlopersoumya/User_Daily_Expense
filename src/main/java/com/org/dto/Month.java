package com.org.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Month {

	@Id
	@Column(name="month_id")
	@GeneratedValue
	private int id;
	
	@Column(name="month_name")
	private String monthName;
	
	@Column(name="month_sal")
	private long salary;
	
	@ManyToOne
	@JoinColumn
	private User user;
	
	@OneToMany(mappedBy = "month",cascade = CascadeType.ALL)
	private List<Expenses>expenses;
	
//	@OneToMany
//	private List<Expenses> expenses;
}
