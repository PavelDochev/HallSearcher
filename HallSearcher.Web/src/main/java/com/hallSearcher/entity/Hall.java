package com.hallSearcher.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "halls")
public class Hall implements Serializable {

    public Hall(){
        this.setAttributes(new HashSet<>());
        this.setAvailabilities(new ArrayList<>());
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private double pricePerHour;

    private double pricePerHourNight;

    private String startOfNightPeriod;

    private String endOfNightPeriod;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "halls_attributes",joinColumns = {@JoinColumn(name = "hall_id")},inverseJoinColumns = {@JoinColumn(name="attribute_id")})
    private Set<HallAttribute> attributes;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
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

    public void addAttribute(HallAttribute attribute){
        this.attributes.add(attribute);
    }

    public void addAvailability(HallAvailability availability){
        this.availabilities.add(availability);
    }
}
