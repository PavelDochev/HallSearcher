package com.hallSearcher.serviceImpl;

import com.hallSearcher.entity.HallAttribute;
import com.hallSearcher.model.HallAttributesViewModel;
import com.hallSearcher.repository.HallAttributesRepository;
import com.hallSearcher.service.HallAttributesService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class HallAttributesImpl implements HallAttributesService {

    private ModelMapper modelMapper;
    private HallAttributesRepository hallAttributesRepository;

    @Autowired
    public HallAttributesImpl(HallAttributesRepository hallAttributesRepository,ModelMapper modelMapper){
        this.hallAttributesRepository = hallAttributesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createHallAttribute(HallAttributesViewModel hallAttribute) {

    }

    @Override
    public List<HallAttributesViewModel> getAllHallAttributes() {

        Type hallAttributesListType = new TypeToken<List<HallAttribute>>() {}.getType();

        return this.modelMapper.map(this.hallAttributesRepository.findAll(),hallAttributesListType);
    }
}
