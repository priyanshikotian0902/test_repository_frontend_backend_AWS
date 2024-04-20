package com.s30project.s30project;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plandiet") 
public class Food {
 
	@Id
    private String food;

    
    private String measure;

    
    private String grams;
    
    
    private String calories;
    
   
    private String carbs;
    
    
    private String category;
    
    public Food() {
    }

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public String getGrams() {
		return grams;
	}

	public void setGrams(String grams) {
		this.grams = grams;
	}

	public String getCalories() {
		return calories;
	}

	public void setCalories(String calories) {
		this.calories = calories;
	}

	public String getCarbs() {
		return carbs;
	}

	public void setCarbs(String carbs) {
		this.carbs = carbs;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	 public Food(String food, String measure, String grams, String calories, String carbs, String category) {
	        this.food = food;
	        this.measure = measure;
	        this.grams = grams;
	        this.calories = calories;
	        this.carbs = carbs;
	        this.category = category;
	    }

    
}
