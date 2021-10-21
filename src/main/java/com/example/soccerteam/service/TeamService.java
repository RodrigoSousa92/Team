package com.example.soccerteam.service;

import com.example.soccerteam.excepetion.ShoeNotFound;
import com.example.soccerteam.excepetion.TeamNotFound;
import com.example.soccerteam.model.Shoe;
import com.example.soccerteam.model.Team;
import com.example.soccerteam.repository.ShoeRepository;
import com.example.soccerteam.repository.TeamRepository;
import com.example.soccerteam.request.ShoeCreationRQ;
import com.example.soccerteam.request.TeamCreationRQ;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {


    TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    //Find all teams
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    //Find by Id
    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow(TeamNotFound::new);
    }


    //Create new teams (List)
    public List<Team> createTeam(List<TeamCreationRQ> teamCreationRQList) {
        List<Team> newTeamList = new ArrayList<>();
        Team newTeam;
        for (TeamCreationRQ teamCreationRQ : teamCreationRQList) {
            newTeam = Team.builder().name(teamCreationRQList.getname()).build();
            teamRepository.save(newTeam);
            newTeamList.add(newTeam);
        }
        return newTeamList;
    }

    //Update team´s by name
    public Team updateTeam(Long id, String name) {
        Team teamToUpdate = this.getTeamById(id);
        teamToUpdate.setName(name);
        teamRepository.save(teamToUpdate);
        return teamToUpdate;
    }

    //Delete by id
    public void deleteById(Long id) {
        this.getTeamById(id);
        teamRepository.deleteById(id);
    }
}