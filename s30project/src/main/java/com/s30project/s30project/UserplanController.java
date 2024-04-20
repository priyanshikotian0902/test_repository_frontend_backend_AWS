package com.s30project.s30project;

import java.sql.Date;
import java.util.ArrayList; 
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserplanController {

    @Autowired
    private UserplanRepository userplanRepository;

    @GetMapping("/all")
    public List<Userplan> getAllUserPlans() {
        return userplanRepository.findAll();
    }
    @GetMapping("/date")
    public ResponseEntity<?> getUserPlanByDate(@RequestParam("date") String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = new Date(dateFormat.parse(dateStr).getTime());
            
            List<Userplan> userPlanList = userplanRepository.findByDate(parsedDate);

            if (userPlanList.isEmpty()) {
                return ResponseEntity.notFound().build(); // No user plans found for the given date
            }

            return ResponseEntity.ok(userPlanList);
        } catch (ParseException e) {
            e.printStackTrace(); // Log the error for debugging
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid date format");
        }
    }
    @DeleteMapping("/plan/{id}") // Use a specific ID for the entry you want to delete
    public ResponseEntity<String> deleteUserPlan(@PathVariable Long id) {
        Optional<Userplan> userPlanOptional = userplanRepository.findById(id);
        
        if (userPlanOptional.isPresent()) {
            userplanRepository.deleteById(id);
            return ResponseEntity.ok("User plan deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/plan")
    public ResponseEntity<String> addUserPlan(@RequestBody Userplan userPlan) {
        userplanRepository.save(userPlan);
        return ResponseEntity.ok("User plan added successfully");
    }

    @GetMapping("/calories/all")
    public ResponseEntity<?> getAllDatesWithSummedCalories() {
        try {
            // Perform a SQL query to sum calories for each date and return as an array of objects
            List<Object[]> results = userplanRepository.sumCaloriesByDate();

            if (results.isEmpty()) {
                return ResponseEntity.notFound().build(); // No data found
            }

            List<Map<String, Object>> dateCaloriesList = new ArrayList<>();
            for (Object[] result : results) {
                Date date = (Date) result[0];
                Double totalCalories = ((Double) result[1]);

                Map<String, Object> dateCaloriesMap = new HashMap<>();
                dateCaloriesMap.put("date", date);
                dateCaloriesMap.put("totalCalories", totalCalories);

                dateCaloriesList.add(dateCaloriesMap);
            }

            return ResponseEntity.ok(dateCaloriesList);
        } catch (Exception e) {
            e.printStackTrace(); // Log the error for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching date-calories data");
        }
    }


    }


