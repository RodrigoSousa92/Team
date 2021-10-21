package com.example.soccerteam.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;


    @ManyToMany(mappedBy = "playerShoes")
    private Set<Shoe> shoes = new HashSet<>();


}

   /* @ManyToOne
    @JoinColumn(name = "id_team")
    Team team;*/

