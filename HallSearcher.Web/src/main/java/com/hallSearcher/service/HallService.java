package com.hallSearcher.service;

import com.hallSearcher.model.HallAttributesViewModel;
import com.hallSearcher.model.HallSearchViewModel;
import com.hallSearcher.model.HallViewModel;

import java.util.List;
import java.util.Set;

public interface HallService {

    void createHall(HallViewModel hall);

    List<HallViewModel> getAll();

    List<HallViewModel> getAllHallsWithGivenAttributes(Set<HallAttributesViewModel> hallAttributes);

    List<HallViewModel> getHallsBySearchCriteria(HallSearchViewModel searchViewModel);
}
