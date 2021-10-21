package com.example.soccerteam.service;

import com.example.soccerteam.excepetion.ShoeNotFound;
import com.example.soccerteam.model.Shoe;
import com.example.soccerteam.repository.ShoeRepository;
import com.example.soccerteam.request.ShoeCreationRQ;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoeService {

    ShoeRepository shoeRepository;

    public ShoeService(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    //Find all shoes
    public List<Shoe> findAll() {
        return shoeRepository.findAll();
    }

    //Find by Id
    public Shoe getShoesById(Long id) {
        return shoeRepository.findById(id).orElseThrow(ShoeNotFound::new);
    }


    //Create new shoes (List)
    public List<Shoe> createShoes(List<ShoeCreationRQ> shoeCreationRQList) {
        List<Shoe> newShoeList = new ArrayList<>();
        Shoe newShoe;
        for (ShoeCreationRQ shoeCreationRQ : shoeCreationRQList) {
            newShoe = Shoe.builder().brand(shoeCreationRQ.getBrand()).build();
            shoeRepository.save(newShoe);
            newShoeList.add(newShoe);
        }
        return newShoeList;
    }

    //Update shoe's by brand
    public Shoe updateShoe(Long id, String brand) {
        Shoe shoeToUpdate = this.getShoesById(id);
        shoeToUpdate.setBrand(brand);
        shoeRepository.save(shoeToUpdate);
        return shoeToUpdate;
    }

    //Delete by id
    public void deleteById(Long id) {
        this.getShoesById(id);
        shoeRepository.deleteById(id);
    }
}