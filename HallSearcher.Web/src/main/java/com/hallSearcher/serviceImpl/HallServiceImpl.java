package com.hallSearcher.serviceImpl;

import com.hallSearcher.entity.Hall;
import com.hallSearcher.entity.HallAttribute;
import com.hallSearcher.model.HallAttributesViewModel;
import com.hallSearcher.model.HallSearchViewModel;
import com.hallSearcher.model.HallViewModel;
import com.hallSearcher.repository.HallRepository;
import com.hallSearcher.service.HallService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class HallServiceImpl implements HallService {

    private ModelMapper modelMapper;
    private HallRepository hallRepository;

    @Autowired
    public HallServiceImpl(HallRepository hallRepository,ModelMapper modelMapper){
        this.hallRepository = hallRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createHall(HallViewModel hall) {
        Hall hallToAdd = this.modelMapper.map(hall,Hall.class);
        this.hallRepository.saveAndFlush(hallToAdd);
    }

    @Override
    public List<HallViewModel> getAll() {
        Type hallAttributesListType = new TypeToken<List<HallAttribute>>() {}.getType();

        List<HallViewModel> halls = new ArrayList<>();

        this.hallRepository.findAll().forEach(x->{
            HallViewModel hall = this.modelMapper.map(x,HallViewModel.class);
            hall.setAttributes(this.modelMapper.map(x.getAttributes(),hallAttributesListType));
            halls.add(hall);
        });

        return halls;
    }

    @Override
    public List<HallViewModel> getAllHallsWithGivenAttributes(Set<HallAttributesViewModel> hallAttributes) {

        Type hallAttributesListType = new TypeToken<List<HallAttribute>>() {}.getType();

        List<HallViewModel> halls = new ArrayList<>();

        Set<HallAttribute> hallAttributesList = this.modelMapper.map(hallAttributes,hallAttributesListType);

        this.hallRepository.findAllByAttributes(hallAttributesList).forEach(x->{
            HallViewModel hall = this.modelMapper.map(x,HallViewModel.class);
            hall.setAttributes(this.modelMapper.map(x.getAttributes(),hallAttributesListType));
            halls.add(hall);
        });

        return halls;
    }

    @Override
    public List<HallViewModel> getHallsBySearchCriteria(HallSearchViewModel searchViewModel) {

        Type hallAttributesListType = new TypeToken<List<HallAttribute>>() { }.getType();

        List<HallViewModel> halls = new ArrayList<>();

        this.hallRepository
                .findAllByAvailabilitiesStartDateLessThan(
                        searchViewModel.getStartDate(),
                        searchViewModel.getEndDate(),
                        this.modelMapper.map(searchViewModel.getHallAttributes(),hallAttributesListType),
                        searchViewModel.getMinPeople());



//        this.hallRepository.findAllBySearchCriteria(searchViewModel).forEach(x -> {
//            HallViewModel hall = this.modelMapper.map(x, HallViewModel.class);
//            hall.setAttributes(this.modelMapper.map(x.getAttributes(), hallAttributesListType));
//            halls.add(hall);
//        });

        return halls;
    }
}
