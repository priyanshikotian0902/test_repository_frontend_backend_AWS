package com.s30project.s30project;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userplan")
public class Userplan {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

public Userplan(Long id, String food, String measure, Double grams, Double calories, Double carbs, String category,
		Date date) {
	super();
	this.id = id;
	this.food = food;
	this.measure = measure;
	this.grams = grams;
	this.calories = calories;
	this.carbs = carbs;
	this.category = category;
	this.date = date;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getMeasure() {
	return measure;
}
public void setMeasure(String measure) {
	this.measure = measure;
}
public Double getGrams() {
	return grams;
}
public void setGrams(Double grams) {
	this.grams = grams;
}
public Double getCalories() {
	return calories;
}
public void setCalories(Double calories) {
	this.calories = calories;
}
public Double getCarbs() {
	return carbs;
}
public void setCarbs(Double carbs) {
	this.carbs = carbs;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
private String food;
private String measure;
private Double grams;
private Double calories;
private Double carbs;
private String category;
private Date date;


public String getFood() {
	return food;
}
public void setFood(String food) {
	this.food = food;
}
public Userplan() {
	super();
	// TODO Auto-generated constructor stub
}

}
