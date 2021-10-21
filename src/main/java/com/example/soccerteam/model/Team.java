package com.example.soccerteam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "team")
public class Team {

    @Id

    private Long id;

    private String name;

  /*  @OneToMany(mappedBy = "team")
    private List<Player> player;*/


}
