package com.hallSearcher.appConfig;

import com.hallSearcher.entity.Hall;
import com.hallSearcher.entity.HallAttribute;
import com.hallSearcher.entity.HallAvailability;
import com.hallSearcher.repository.HallAttributesRepository;
import com.hallSearcher.repository.HallRepository;
import com.hallSearcher.service.HallAttributesService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class AppConfig {
    private HallAttributesService hallAttributesService;

    private HallAttributesRepository hallAttributesRepository;
    private HallRepository hallRepository;
    private ModelMapper modelMapper;

    @Autowired
    public AppConfig(HallAttributesService hallAttributesService,
                     HallRepository hallRepository,
                     HallAttributesRepository hallAttributesRepository,
                     ModelMapper modelMapper){
        this.hallAttributesService = hallAttributesService;
        this.hallRepository = hallRepository;
        this.hallAttributesRepository = hallAttributesRepository;
        this.modelMapper = modelMapper;
    }


    @Bean
    public Hall createHall(){

        //add some attributes to db

        List<HallAttribute> hallAttributes = new ArrayList<>();

        HallAttribute firstAttr = new HallAttribute();
        firstAttr.setName("маси");

        HallAttribute secondAttr = new HallAttribute();
        secondAttr.setName("прожектор");

        HallAttribute thirdAttr = new HallAttribute();
        thirdAttr.setName("амфитеатрална");

        HallAttribute fourthAttr = new HallAttribute();
        fourthAttr.setName("столчета с маси на гърба");

        hallAttributes.add(firstAttr);
        hallAttributes.add(secondAttr);
        hallAttributes.add(thirdAttr);
        hallAttributes.add(fourthAttr);

        this.hallAttributesRepository.saveAll(hallAttributes);
        this.hallAttributesRepository.flush();

        Type hallAttributesListType = new TypeToken<List<HallAttribute>>() {}.getType();

        List<HallAttribute> hallAttributesList = this.modelMapper.map(this.hallAttributesService.getAllHallAttributes(),hallAttributesListType);

        List<Hall> hallList = new ArrayList<>();

        Hall firstHall = new Hall();
        firstHall.setName("Зала 1");
        firstHall.setStartOfNightPeriod("19:00");
        firstHall.setEndOfNightPeriod("08:00");
        firstHall.setPricePerHour(1);
        firstHall.setPricePerHourNight(2);
        firstHall.setMinNumberOfPeople(12);


        //add attr
        firstHall.addAttribute(hallAttributesList.get(0));
        firstHall.addAttribute(hallAttributesList.get(1));

        Hall secondHall = new Hall();
        secondHall.setName("Зала 2");
        secondHall.setStartOfNightPeriod("20:00");
        secondHall.setEndOfNightPeriod("08:00");
        secondHall.setPricePerHour(1);
        secondHall.setPricePerHourNight(2);
        secondHall.setMinNumberOfPeople(20);

        //add attr
        secondHall.addAttribute(hallAttributesList.get(2));
        secondHall.addAttribute(hallAttributesList.get(3));

        Hall thirdHall = new Hall();
        thirdHall.setName("Зала 3");
        thirdHall.setStartOfNightPeriod("22:00");
        thirdHall.setEndOfNightPeriod("10:00");
        thirdHall.setPricePerHour(1);
        thirdHall.setPricePerHourNight(2);
        thirdHall.setMinNumberOfPeople(10);

        //add attr
        thirdHall.addAttribute(hallAttributesList.get(0));
        thirdHall.addAttribute(hallAttributesList.get(1));
        thirdHall.addAttribute(hallAttributesList.get(2));

        Hall fourthHall = new Hall();
        fourthHall.setName("Зала 4");
        fourthHall.setStartOfNightPeriod("22:00");
        fourthHall.setEndOfNightPeriod("10:00");
        fourthHall.setPricePerHour(1);
        fourthHall.setPricePerHourNight(2);
        fourthHall.setMinNumberOfPeople(10);

        //add attr
        fourthHall.addAttribute(hallAttributesList.get(0));
        fourthHall.addAttribute(hallAttributesList.get(1));
        fourthHall.addAttribute(hallAttributesList.get(2));
        fourthHall.addAttribute(hallAttributesList.get(3));


        hallList.add(firstHall);
        hallList.add(secondHall);
        hallList.add(thirdHall);
        hallList.add(fourthHall);

        hallList.forEach(x-> {
            HallAvailability availability = new HallAvailability();
            LocalDateTime startDate = LocalDateTime.of(2018, 3, 1, 10, 00);
            LocalDateTime endDate = LocalDateTime.of(2018,3,2,13,00);

            availability.setStartDate(startDate.atZone(ZoneId.systemDefault()).toEpochSecond());
            availability.setEndDate(endDate.atZone(ZoneId.systemDefault()).toEpochSecond());

            x.addAvailability(availability);

            HallAvailability secondAvailability = new HallAvailability();
            LocalDateTime startDateS = LocalDateTime.of(2018,3,2,16,00);
            LocalDateTime endDateS = LocalDateTime.of(2018,3,2,22,00);

            secondAvailability.setStartDate(startDateS.atZone(ZoneId.systemDefault()).toEpochSecond());
            secondAvailability.setEndDate(endDateS.atZone(ZoneId.systemDefault()).toEpochSecond());

            x.addAvailability(secondAvailability);

        });


        this.hallRepository.saveAll(hallList);
        this.hallRepository.flush();

        return firstHall;
    }
}
