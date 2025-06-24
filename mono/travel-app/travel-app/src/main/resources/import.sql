create sequence travelorder_sequence start with 1 increment by 1;
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));

create sequence flight_sequence start with 1 increment by 1;
INSERT INTO TravelFlight(id,travelorderid,fromAirport,toAirport) VALUES (nextval('travelorder_sequence'),1,'GRU','MCO');
INSERT INTO TravelFlight(id,travelorderid,fromAirport,toAirport) VALUES (nextval('travelorder_sequence'),2,'SGU','JFK');
INSERT INTO TravelFlight(id,travelorderid,fromAirport,toAirport) VALUES (nextval('travelorder_sequence'),3,'GRU','JFK');
INSERT INTO TravelFlight(id,travelorderid,fromAirport,toAirport) VALUES (nextval('travelorder_sequence'),4,'GRU','MEX');

