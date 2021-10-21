package com.example.soccerteam.repository;

import com.example.soccerteam.model.Shoe;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Long> {
}
