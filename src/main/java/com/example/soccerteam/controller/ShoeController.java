package com.example.soccerteam.controller;

import com.example.soccerteam.model.Shoe;
import com.example.soccerteam.request.ShoeCreationRQ;
import com.example.soccerteam.request.UpdateShoeBrandRQ;
import com.example.soccerteam.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class ShoeController {

    @Autowired
    ShoeService shoeService;

    //Get all shoes
    @GetMapping("/Shoes")
    public List<Shoe> getShoes() {
        return shoeService.findAll();
    }

    //Get shoe by id
    @GetMapping("/Shoes/{id}")
    public Shoe getShoesById(@PathVariable Long id) {
        return shoeService.getShoesById(id);
    }

    //Create shoe
    @PostMapping(value = "/Shoes")
    public List<Shoe> createShoes(@RequestBody @Valid List<ShoeCreationRQ> shoeCreationRQS) {
        return shoeService.createShoes(shoeCreationRQS);
    }

    //Update shoe
    @PutMapping(value = "/Shoe-update/{id}")
    public Shoe updateShoeName(@PathVariable(value = "id") Long id, @RequestBody UpdateShoeBrandRQ updateShoeBrandRQ) {
        return shoeService.updateShoe(id, updateShoeBrandRQ.getBrand());
    }

    //Delete shoe
    @DeleteMapping(path = "/delete-shoe/{id}")
    public ResponseEntity deleteShoe(@PathVariable(value = "id") Long shoeId) {
        shoeService.deleteById(shoeId);
        return ResponseEntity.created(URI.create("/shoe")).body("shoe removed");
    }

}
