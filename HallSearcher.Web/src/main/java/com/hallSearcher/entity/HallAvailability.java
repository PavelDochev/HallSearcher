package com.hallSearcher.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hallAvailabilities")
public class HallAvailability implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long startDate;

    private long endDate;

    @ManyToOne
    private Hall hall;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }
}
