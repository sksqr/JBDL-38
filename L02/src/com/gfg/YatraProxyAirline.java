package com.gfg;

import java.util.Date;
import java.util.List;

public class YatraProxyAirline implements AirlineInterface{
    @Override
    public List<Flight> getFlights(String src, String des, Date date) {
        System.out.println("yatra");
        return null;
    }

    @Override
    public List<Flight> getFlights(String src, String des, Date date, String airline) {
        return null;
    }
}
