package com.s30project.s30project;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/food")
    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    @GetMapping("/find")
    public List<Food> getFoodByName(@RequestParam(name = "food", required = false) String food) {
        if (food != null) {
            return foodRepository.findByFoodContainingIgnoreCase(food);
        } else {
            return foodRepository.findAll();
        }
    }
    
    @PostMapping("/addFood")
    public ResponseEntity<String> addFood(@RequestBody Food food) {
    	 Food savedFood = foodRepository.save(food);
        return ResponseEntity.ok("Food added successfully");
    }

}
