package com.hallSearcher.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

public class HallSearchViewModel {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int minPeople;
    private Set<HallAttributesViewModel> hallAttributes;

    public int getMinPeople() {
        return minPeople;
    }

    public void setMinPeople(int minPeople) {
        this.minPeople = minPeople;
    }

    public Set<HallAttributesViewModel> getHallAttributes() {
        return hallAttributes;
    }

    public void setHallAttributes(Set<HallAttributesViewModel> hallAttributes) {
        this.hallAttributes = hallAttributes;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
