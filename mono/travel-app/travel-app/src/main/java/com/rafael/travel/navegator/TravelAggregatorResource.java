package com.rafael.travel.navegator;

import com.rafael.travel.flight.TravelFlight;
import com.rafael.travel.flight.TravelFlightResource;
import com.rafael.travel.hotel.TravelHotel;
import com.rafael.travel.hotel.TravelHotelResource;
import com.rafael.travel.order.TravelOrder;
import com.rafael.travel.order.TravelOrderResource;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Path("travel-aggregator")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TravelAggregatorResource {
    @Inject
    TravelFlightResource travelFlightResource;
    @Inject
    TravelHotelResource travelHotelResource;

    @Inject
    TravelOrderResource travelOrderResource;

    @GET
    public List<TravelAggregatorDTO> travelAggregatorDTOS() {

        return TravelOrder.<TravelOrder>listAll().stream()
                .map(
                        order -> TravelAggregatorDTO.of(
                                order,
                                travelFlightResource.findByTravelOrderId(order.id),
                                travelHotelResource.findByTravelOrderId(order.id)
                        )
                ).collect(Collectors.toList());
    }

    @GET
    @Path("findByIDTravelAggregator")
    public TravelAggregatorDTO travelAggregatorDTOS(long id) {

        return TravelOrder.<TravelOrder>listAll().stream().findFirst()
                .map(
                        order -> TravelAggregatorDTO.of(
                                order,
                                travelFlightResource.findByTravelOrderId(order.id),
                                travelHotelResource.findByTravelOrderId(order.id)
                        )
                ).orElse(null);
    }



    @POST
    public TravelAggregatorDTO newAggregatorDTO(TravelAggregatorDTO travelAggregatorDTO){
        TravelOrder travelOrder = new TravelOrder();
        travelOrder=travelOrderResource.newTravelOrder(travelOrder);

        TravelFlight travelFlight = new TravelFlight();
        travelFlight.fromAirport = travelAggregatorDTO.getFromAirport();
        travelFlight.toAirport = travelAggregatorDTO.getToAirport();
        travelFlight.travelOrderId = travelOrder.id;

        travelFlight = travelFlightResource.newFlight(travelFlight);

        TravelHotel travelHotel = new TravelHotel();
        travelHotel.nights = travelAggregatorDTO.getNights();
        travelHotel.travelOrderId = travelOrder.id;

        travelHotel=travelHotelResource.newTravelHotel(travelHotel);

        return TravelAggregatorDTO.of(travelOrder,travelFlight,travelHotel);
    }
}
