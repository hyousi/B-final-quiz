package com.example.demo.service;

import com.example.demo.domain.Team;
import com.example.demo.domain.Trainee;
import com.example.demo.domain.Trainer;
import com.example.demo.repository.TeamRepository;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final TrainerRepository trainerRepository;
    private final TraineeRepository traineeRepository;

    public TeamService(TeamRepository teamRepository,
        TrainerRepository trainerRepository,
        TraineeRepository traineeRepository) {
        this.teamRepository = teamRepository;
        this.trainerRepository = trainerRepository;
        this.traineeRepository = traineeRepository;
    }

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public void createTeams() {
        List<Trainer> trainers = trainerRepository.findAll();
        List<Trainee> trainees = traineeRepository.findAll();

        if (trainers.size() < 2) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        List<Team> teams = new ArrayList<>();

        Random random = new Random();
        int trainerIdx;
        int teamSize = Math.floorDiv(trainers.size(), 2);
        for (int i = 0; i < teamSize; i++) {
            Team team = new Team((long) i);
            trainerIdx = random.nextInt(trainers.size());
            team.getTrainers().add(trainers.remove(trainerIdx));
            trainerIdx = random.nextInt(trainers.size());
            team.getTrainers().add(trainers.remove(trainerIdx));
            teams.add(team);
        }

        Collections.shuffle(trainees);
        int i = 0;
        for (Trainee trainee : trainees) {
            teams.get(i).getTrainees().add(trainee);
            i = (i + 1) % teamSize;
        }

        for (Team team : teams) {
            teamRepository.save(team);
        }
    }

}
