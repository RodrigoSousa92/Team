package com.example.soccerteam.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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

    private String team;

  /*  @OneToMany(mappedBy = "team")
    private List<Player> player;*/


}
