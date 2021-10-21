package com.example.soccerteam.controller;

import com.example.soccerteam.model.Player;
import com.example.soccerteam.request.PlayerCreationRQ;
import com.example.soccerteam.request.UpdatePlayerNameRQ;
import com.example.soccerteam.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class PlayerController {

    @Autowired
    PlayerService playerService;

    //Get all players
    @GetMapping("/Players")
    public List<Player> getPlayers() {
        return playerService.findAll();
    }

    //Get players by id
    @GetMapping("/Players/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.getPlayersById(id);
    }


    //Create player
    @PostMapping(value = "/Players")
    public List<Player> createPlayers(@RequestBody @Valid List<PlayerCreationRQ> createPlayerRQ) {
        return playerService.createPlayers(createPlayerRQ);
    }

    //Update player
    @PutMapping(value = "/Player-update/{id}")
    public Player updatePlayerName(@PathVariable(value = "id") Long id, @RequestBody UpdatePlayerNameRQ updatePlayerNameRQ) {
        return playerService.updatePlayer(id, updatePlayerNameRQ.getName());
    }

    //Delete player
    @DeleteMapping(value = "/Player-delete/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        playerService.deleteById(id);
    }

}
