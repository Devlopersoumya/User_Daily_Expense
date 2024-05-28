package com.org.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class Expenses {

	@Id
	@Column(name="expenses_id")
	@GeneratedValue
	private int id;
	
	@Column(name="purches_date")
	private String date;
	
	@Column(name="purches_cause")
	private String cause;
	
	@Column(name="product_name")
	private String name;
	
	@Column(name="purching_time")
	private String time;
	
	@Column(name="product_price")
	private long price;
	
	
	@ManyToOne
	@JoinColumn
	private Month month;
	
//	@ManyToOne
//	@JoinColumn
//	private User user;
	
//	@ManyToOne
//	private Month month;
}
