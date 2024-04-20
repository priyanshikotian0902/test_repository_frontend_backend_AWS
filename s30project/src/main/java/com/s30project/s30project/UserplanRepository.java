package com.s30project.s30project;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserplanRepository extends JpaRepository<Userplan, Long> {
	List<Userplan> findByDate(Date date);
	    
	    
	    @Query("SELECT u.date, SUM(u.calories) FROM Userplan u GROUP BY u.date")
	    List<Object[]> sumCaloriesByDate();
	}




