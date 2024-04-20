

package com.s30project.s30project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BmiService {
    @Autowired
    private BmiRepository bmiRepository;

    public Bmi saveBmi(Bmi bmi) {
        return bmiRepository.save(bmi);
    }
}
