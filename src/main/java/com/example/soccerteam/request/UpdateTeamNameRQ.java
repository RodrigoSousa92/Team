package com.example.soccerteam.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateTeamNameRQ {
    private String name;
}
