package com.example.demo.service;

import com.example.demo.domain.Trainee;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.TraineeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class TraineeService {

    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public List<Trainee> getAll(boolean isGrouped) {
        if (isGrouped) {
            return traineeRepository.findAllByTeamIsNotNull();
        } else {
            return traineeRepository.findAllByTeamIsNull();
        }
    }

    public Trainee add(Trainee trainee) {
        return traineeRepository.save(trainee);
    }

    public void delete(Long id) {
        Optional<Trainee> trainee = traineeRepository.findById(id);
        if (!trainee.isPresent()) {
            throw new UserNotFoundException();
        }
        traineeRepository.deleteById(id);
    }
}
