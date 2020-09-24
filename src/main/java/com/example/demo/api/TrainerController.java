package com.example.demo.api;

import com.example.demo.domain.Trainer;
import com.example.demo.service.TrainerService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:1234")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping("/trainers")
    @ResponseStatus(HttpStatus.CREATED)
    public Trainer add(@RequestBody @Valid Trainer trainee) {
        return trainerService.add(trainee);
    }

    @GetMapping("/trainers")
    public List<Trainer> getAll(@RequestParam(value = "grouped") boolean isGrouped) {
        return trainerService.getAll(isGrouped);
    }
}
