package com.example.demo.api;

import com.example.demo.domain.Team;
import com.example.demo.service.TeamService;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:1234")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/groups")
    public List<Team> getAll() {
        return teamService.getAll();
    }

    @PostMapping("/groups/auto-grouping")
    public List<Team> createTeams() {
        teamService.createTeams();
        return teamService.getAll();
    }
}
