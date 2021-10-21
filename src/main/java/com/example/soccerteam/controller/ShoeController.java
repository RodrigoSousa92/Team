package com.example.soccerteam.controller;

import com.example.soccerteam.model.Player;
import com.example.soccerteam.request.PlayerCreationRQ;
import com.example.soccerteam.request.UpdatePlayerNameRQ;
import com.example.soccerteam.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class ShoeController {


    @Autowired
    ShoeService shoeService;

    //Get all shoes
    @GetMapping("/Shoes")
    public List<Player> getPlayers() {
        return shoeService.findAll();
    }

    //Get shoe by id
    @GetMapping("/Shoes/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.getPlayersById(id);
    }


    //Create shoe
    @PostMapping(value = "/Shoes")
    public List<Player> createPlayers(@RequestBody @Valid List<PlayerCreationRQ> createPlayerRQ) {
        return playerService.createPlayers(createPlayerRQ);
    }

    //Update shoe
    @PutMapping(value = "/Shoe-update/{id}")
    public Player updatePlayerName(@PathVariable(value = "id") Long id, @RequestBody UpdatePlayerNameRQ updatePlayerNameRQ) {
        return shoeService.updateShoe(id,updatePlayerNameRQ.getName());
    }

    //Delete player
    @DeleteMapping(value = "/Player-delete/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        playerService.deleteById(id);
    }

}
