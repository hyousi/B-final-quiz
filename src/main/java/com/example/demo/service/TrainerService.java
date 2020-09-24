package com.example.demo.service;

import com.example.demo.domain.Trainer;
import com.example.demo.repository.TrainerRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public Trainer add(Trainer trainee) {
        return trainerRepository.save(trainee);
    }

    public List<Trainer> getAll(boolean isGrouped) {
        if (isGrouped) {
            return trainerRepository.findAllByTeamIsNotNull();
        }
        return trainerRepository.findAllByTeamIsNull();
    }

}
