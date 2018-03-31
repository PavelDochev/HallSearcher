package com.hallSearcher.model;

import com.hallSearcher.entity.HallAttribute;
import com.hallSearcher.entity.HallAvailability;

import java.util.List;
import java.util.Set;

public class HallViewModel {

    private long id;

    private String name;

    private double pricePerHour;

    private double pricePerHourNight;

    private String startOfNightPeriod;

    private int minNumberOfPeople;

    private String endOfNightPeriod;

    private Set<HallAttribute> attributes;

    private List<HallAvailability> availabilities;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public double getPricePerHourNight() {
        return pricePerHourNight;
    }

    public void setPricePerHourNight(double pricePerHourNight) {
        this.pricePerHourNight = pricePerHourNight;
    }


    public Set<HallAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<HallAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<HallAvailability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<HallAvailability> availabilities) {
        this.availabilities = availabilities;
    }

    public String getStartOfNightPeriod() {
        return startOfNightPeriod;
    }

    public void setStartOfNightPeriod(String startOfNightPeriod) {
        this.startOfNightPeriod = startOfNightPeriod;
    }

    public String getEndOfNightPeriod() {
        return endOfNightPeriod;
    }

    public void setEndOfNightPeriod(String endOfNightPeriod) {
        this.endOfNightPeriod = endOfNightPeriod;
    }

    public int getMinNumberOfPeople() {
        return minNumberOfPeople;
    }

    public void setMinNumberOfPeople(int minNumberOfPeople) {
        this.minNumberOfPeople = minNumberOfPeople;
    }
}
