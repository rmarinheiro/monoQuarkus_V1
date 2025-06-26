package com.rafael.travel.hotel;

import com.rafael.travel.flight.TravelFlight;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("travel-hotel")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TravelHotelResource {

    @GET
    public List<TravelHotel> findAll() {
        return TravelHotel.listAll();
    }

    @GET()
    @Path("findById")
    public TravelHotel findById(long id) {
        return TravelHotel.findById(id);
    }

    @GET
    @Path("findByTravelOrderId")
    public TravelHotel findByTravelOrderId(@QueryParam("travelOrderId") Long id){
        return TravelHotel.findByTravelOrderId(id);
    }

    @POST
    @Transactional
    public TravelHotel newTravelHotel(TravelHotel travelHotel) {
        travelHotel.id = null;
        travelHotel.persist();
        return travelHotel;
    }

    @DELETE
    @Transactional
    public Response deleteTravelHotel(long id){
        TravelHotel.deleteById(id);
        return Response.accepted().build();
    }
}
