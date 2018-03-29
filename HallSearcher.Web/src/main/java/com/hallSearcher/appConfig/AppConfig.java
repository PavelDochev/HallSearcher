package com.hallSearcher.appConfig;

import com.hallSearcher.entity.Hall;
import com.hallSearcher.entity.HallAvailability;
import com.hallSearcher.repository.HallRepository;
import com.hallSearcher.service.HallAttributesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class AppConfig {
    private HallAttributesService hallAttributesService;

    private HallRepository hallRepository;
    private ModelMapper modelMapper;

    @Autowired
    public AppConfig(HallAttributesService hallAttributesService,
                     HallRepository hallRepository,
                     ModelMapper modelMapper){
        this.hallAttributesService = hallAttributesService;
        this.hallRepository = hallRepository;
        this.modelMapper = modelMapper;
    }


    @Bean
    public Hall addHallAvailabilities(){

        List<Hall> halls = this.hallRepository.findAll();

        halls.forEach(x-> {
//            HallAvailability availability = new HallAvailability();
//            Date startDate = new Date(2018,3,2,10,00);
//            Date endDate = new Date(2018,3,2,13,00);
//
//            availability.setStartDate(startDate);
//            availability.setEndDate(endDate);
//
//            x.addAvailability(availability);

            HallAvailability secondAvailability = new HallAvailability();
            Date startDateS = new Date(2018,3,2,16,00);
            Date endDateS = new Date(2018,3,2,22,00);

            secondAvailability.setStartDate(startDateS);
            secondAvailability.setEndDate(endDateS);

            x.addAvailability(secondAvailability);

        });

        this.hallRepository.saveAll(halls);
        this.hallRepository.flush();


        return new Hall();
    }

//    @Bean
//    public Hall createHall(){
//
//        //add some attributes to db
//
//        Type hallAttributesListType = new TypeToken<List<HallAttributes>>() {}.getType();
//
//        List<HallAttributes> hallAttributesList = this.modelMapper.map(this.hallAttributesService.getAllHallAttributes(),hallAttributesListType);
//
//        List<Hall> hallList = new ArrayList<>();
//
//        Hall firstHall = new Hall();
//        firstHall.setName("Зала 1");
//        firstHall.setStartOfNightPeriod("19:00");
//        firstHall.setEndOfNightPeriod("08:00");
//        firstHall.setPricePerHour(1);
//        firstHall.setPricePerHourNight(2);
//
//        //add attr
//        firstHall.addAttribute(hallAttributesList.get(0));
//        firstHall.addAttribute(hallAttributesList.get(1));
//
//        Hall secondHall = new Hall();
//        secondHall.setName("Зала 2");
//        secondHall.setStartOfNightPeriod("20:00");
//        secondHall.setEndOfNightPeriod("08:00");
//        secondHall.setPricePerHour(1);
//        secondHall.setPricePerHourNight(2);
//
//        //add attr
//        secondHall.addAttribute(hallAttributesList.get(2));
//
//        Hall thirdHall = new Hall();
//        thirdHall.setName("Зала 3");
//        thirdHall.setStartOfNightPeriod("22:00");
//        thirdHall.setEndOfNightPeriod("10:00");
//        thirdHall.setPricePerHour(1);
//        thirdHall.setPricePerHourNight(2);
//
//        //add attr
//        thirdHall.addAttribute(hallAttributesList.get(0));
//        thirdHall.addAttribute(hallAttributesList.get(1));
//        thirdHall.addAttribute(hallAttributesList.get(2));
//
//        hallList.add(firstHall);
//        hallList.add(secondHall);
//        hallList.add(thirdHall);
//
//        this.hallRepository.saveAll(hallList);
//        this.hallRepository.flush();
//
//        return firstHall;
//    }
}
