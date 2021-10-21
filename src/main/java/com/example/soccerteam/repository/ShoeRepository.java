package com.example.soccerteam.repository;

import com.example.soccerteam.model.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeRepository extends JpaRepository <Shoe, Long>{
}
