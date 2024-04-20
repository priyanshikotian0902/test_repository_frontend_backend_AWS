package com.s30project.s30project;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bmi")
public class Bmi {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    
    private Date date;
    private float bmiresult;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getBmiresult() {
		return bmiresult;
	}
	public void setBmiresult(float bmiresult) {
		this.bmiresult = bmiresult;
	}
	public Bmi(Long id, Date date, float bmiresult) {
		super();
		this.id = id;
		this.date = date;
		this.bmiresult = bmiresult;
	}
	public Bmi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	}

