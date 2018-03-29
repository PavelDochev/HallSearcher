package com.hallSearcher.model;

import java.util.Date;
import java.util.Set;

public class HallSearchViewModel {

    private Date startDate;
    private Date endDate;
    private int minPeople;
    private Set<HallAttributesViewModel> hallAttributes;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

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
}
