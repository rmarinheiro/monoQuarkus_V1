package com.rafael.travel.flight;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class TravelFlight extends PanacheEntity {
    public Long travelOrderId;
    public String fromAirport;
    public String toAirport;

    public static TravelFlight findByTravelOrderId(Long id){
        return find("travelOrderId",id).firstResult();
    }
}
