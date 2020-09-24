package com.example.demo.api;

import com.example.demo.domain.Trainee;
import com.example.demo.service.TraineeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraineeController {

    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping("/trainees")
    public List<Trainee> getAll(@RequestParam(value = "grouped") boolean isGrouped) {
        return traineeService.getAll(isGrouped);
    }
}
