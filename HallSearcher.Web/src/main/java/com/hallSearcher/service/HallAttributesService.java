package com.hallSearcher.service;

import com.hallSearcher.entity.HallAttribute;
import com.hallSearcher.model.HallAttributesViewModel;

import java.util.List;

public interface HallAttributesService {

    void createHallAttribute(HallAttributesViewModel hallAttribute);
    List<HallAttributesViewModel> getAllHallAttributes();
}
