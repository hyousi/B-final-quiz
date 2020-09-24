package com.example.demo.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @OneToMany
    private Set<Trainee> trainees = new HashSet<>();

    @OneToMany
    private Set<Trainer> trainers = new HashSet<>();

    public Team(Long id) {
        this.id = id;
        this.name = id + "组";
    }
}
