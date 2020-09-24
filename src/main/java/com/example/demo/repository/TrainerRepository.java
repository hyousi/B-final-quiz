package com.example.demo.repository;

import com.example.demo.domain.Trainer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    List<Trainer> findAllByTeamIsNotNull();

    List<Trainer> findAllByTeamIsNull();
}
