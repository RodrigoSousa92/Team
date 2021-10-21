package com.example.soccerteam.repository;

import com.example.soccerteam.model.Player;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Primary
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
