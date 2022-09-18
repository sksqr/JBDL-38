package com.gfg;

import java.util.Date;
import java.util.List;

public class EaseMyTripAirline implements AirlineInterface{
    @Override
    public  List<Flight> getFlights(String src, String des, Date date) {
            System.out.println("Ease my trip");
        return null;
    }

    @Override
    public List<Flight> getFlights(String src, String des, Date date, String airline) {
        return null;
    }
}
