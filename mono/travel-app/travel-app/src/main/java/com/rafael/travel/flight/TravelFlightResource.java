package com.rafael.travel.flight;

import com.rafael.travel.order.TravelOrder;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("travel-flight")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TravelFlightResource {

    @GET
    public List<TravelFlight> travelFlights() {
        return TravelFlight.listAll();
    }

    @GET
    @Path("findById")
    public TravelFlight findById(@QueryParam("id") Long id){
        return TravelFlight.findById(id);
    }

    @GET
    @Path("findByTravelOrderId")
    public TravelFlight findByTravelOrderId(@QueryParam("travelOrderId") Long id){
        return TravelFlight.findByTravelOrderId(id);
    }

    @POST
    @Transactional
    public TravelFlight newFlight(TravelFlight travelFlight) {
        travelFlight.id = null;
        travelFlight.persist();
        return travelFlight;
    }

    @DELETE
    @Transactional
    public Response deleteTravelFligth(long id){
        TravelFlight.deleteById(id);
        return Response.accepted().build();
    }
}
