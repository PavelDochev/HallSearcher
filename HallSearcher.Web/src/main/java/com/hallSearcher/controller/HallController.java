package com.hallSearcher.controller;

import com.hallSearcher.model.HallSearchViewModel;
import com.hallSearcher.model.HallViewModel;
import com.hallSearcher.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HallController {
    private HallService hallService;

    @Autowired
    public HallController(HallService hallService){
        this.hallService = hallService;
    }

    @GetMapping("api/hall/search")
    public List<HallViewModel> searchHalls(@RequestBody HallSearchViewModel hallSearchVM){

        return this.hallService.getHallsBySearchCriteria(hallSearchVM);
    }

}
