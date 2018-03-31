package com.hallSearcher.controller;


import com.hallSearcher.model.HallAttributesViewModel;
import com.hallSearcher.service.HallAttributesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HallAttributesController {
    private HallAttributesService hallAttributesService;

    @Autowired
    public HallAttributesController(HallAttributesService hallAttributesService){
        this.hallAttributesService = hallAttributesService;
    }

    @CrossOrigin
    @GetMapping("api/getHallAttributes")
    public List<HallAttributesViewModel> getAllHallAttributes(){

        return this.hallAttributesService.getAllHallAttributes();
    }
}
