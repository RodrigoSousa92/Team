package com.example.soccerteam.service;

import com.example.soccerteam.excepetion.PlayerNotFound;
import com.example.soccerteam.model.Player;
import com.example.soccerteam.repository.PlayerRepository;
import com.example.soccerteam.request.PlayerCreationRQ;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    //Find all members
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    //Find by Id
    public Player getPlayersById(Long id) {
        return playerRepository.findById(id).orElseThrow(PlayerNotFound::new);
    }


    //Create new player (List)
    public List<Player> createPlayers(List<PlayerCreationRQ> playerCreationRQList) {
        List<Player> newPlayerList = new ArrayList<>();
        Player newPlayer;
        for (PlayerCreationRQ playerCreationRQ : playerCreationRQList) {
            newPlayer = Player.builder().name(playerCreationRQ.getName()).build();
            playerRepository.save(newPlayer);
            newPlayerList.add(newPlayer);
        }
        return newPlayerList;
    }

    //Update player's by name
    public Player updatePlayer(Long id, String name) {
        Player playerToUpdate = this.getPlayersById(id);
        playerToUpdate.setName(name);
        playerRepository.save(playerToUpdate);
        return playerToUpdate;
    }

    //Delete by id
    public void deleteById(Long id) {
        this.getPlayersById(id);
        playerRepository.deleteById(id);
    }
}
