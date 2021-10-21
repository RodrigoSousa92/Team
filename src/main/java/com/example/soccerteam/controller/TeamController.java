package com.example.soccerteam.controller;

import com.example.soccerteam.model.Player;
import com.example.soccerteam.model.Team;
import com.example.soccerteam.request.PlayerCreationRQ;
import com.example.soccerteam.request.TeamCreationRQ;
import com.example.soccerteam.request.UpdatePlayerNameRQ;
import com.example.soccerteam.request.UpdateTeamNameRQ;
import com.example.soccerteam.service.PlayerService;
import com.example.soccerteam.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class TeamController {

    @Autowired
    TeamService teamService;

    //Get all teams
    @GetMapping("/Teams")
    public List<Team> getTeams() {
        return teamService.findAll();
    }

    //Get team by id
    @GetMapping("/Team/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }

    //Create teams
    @PostMapping(value = "/Teams")
    public List<Team> createTeam(@RequestBody @Valid List<TeamCreationRQ> createTeamRQ) {
        return teamService.createTeam(createTeamRQ);
    }

    //Update team
    @PutMapping(value = "/Team-update/{id}")
    public Team updateTeamName(@PathVariable(value = "id") Long id, @RequestBody UpdateTeamNameRQ updateTeamNameRQ) {
        return teamService.updateTeam(id, updateTeamNameRQ.getName());
    }

    //Delete team
    @DeleteMapping(value = "/Team-delete/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        teamService.deleteById(id);
    }

}
