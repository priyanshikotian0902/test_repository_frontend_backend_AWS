package com.s30project.s30project;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BmiController {

    @Autowired
    private BmiRepository bmiRepository;
    @GetMapping("/bmi")
    public List<Bmi> getAllBmi() {
        return bmiRepository.findAll();
    }
    @GetMapping("/getbmi")
    public ResponseEntity<?> getBmiByDate(@RequestParam("date") String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = new Date(dateFormat.parse(dateStr).getTime());
            
            List<Bmi> bmiList = bmiRepository.findByDate(parsedDate);

            if (bmiList.isEmpty()) {
                return ResponseEntity.notFound().build(); // No BMI data found for the given date
            }

            return ResponseEntity.ok(bmiList);
        } catch (ParseException e) {
            e.printStackTrace(); // Log the error for debugging
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid date format");
        }
    }

    @PostMapping("/postbmi")
    public ResponseEntity<String> addBmi(@RequestBody Bmi bmi) {
        bmiRepository.save(bmi);
        return ResponseEntity.ok("Bmi added successfully");
    }
    
    @DeleteMapping("/delbmi")
    public ResponseEntity<String> deleteBmiByDate(@RequestParam("date") String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = new Date(dateFormat.parse(dateStr).getTime());

            // Attempt to find a BMI entry with the specified date
            List<Bmi> bmi = bmiRepository.findByDate(parsedDate);

            if (bmi == null) {
                return ResponseEntity.notFound().build(); // No BMI data found for the given date
            }

            // Delete the found BMI entry
            bmiRepository.deleteAll(bmi);

            return ResponseEntity.ok("Bmi entry deleted successfully for date: " + dateStr);
        } catch (ParseException e) {
            e.printStackTrace(); // Log the error for debugging
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid date format");
        }
    }

}
