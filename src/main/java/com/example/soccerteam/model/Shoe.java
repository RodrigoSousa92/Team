package com.example.soccerteam.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "shoe")
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;




    @ManyToMany
    @JoinTable(
            name = "players_shoes",
            joinColumns = @JoinColumn(name = "shoe_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<Player> playerShoes = new HashSet<>();
}






