package com.rafael.travel.flight;

import com.rafael.travel.order.TravelOrder;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class TravelFlight extends PanacheEntity {
    public Long TravelOrderId;
    public String fromAirport;
    public String toAirport;
}
