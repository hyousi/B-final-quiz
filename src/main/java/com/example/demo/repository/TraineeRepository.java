package com.example.demo.repository;

import com.example.demo.domain.Trainee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {

    List<Trainee> findAllByTeamIsNotNull();

    List<Trainee> findAllByTeamIsNull();
}
