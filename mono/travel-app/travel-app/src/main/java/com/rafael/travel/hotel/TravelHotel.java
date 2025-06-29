package com.rafael.travel.hotel;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class TravelHotel extends PanacheEntity {
    public long travelOrderId;
    public Integer nights;

    public static TravelHotel findByTravelOrderId(Long id){
        return find("travelOrderId",id).firstResult();
    }

}
