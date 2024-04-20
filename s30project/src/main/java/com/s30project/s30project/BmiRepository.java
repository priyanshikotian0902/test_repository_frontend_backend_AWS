package com.s30project.s30project;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BmiRepository extends JpaRepository<Bmi, Long> {
	List<Bmi> findByDate(Date date);

}
