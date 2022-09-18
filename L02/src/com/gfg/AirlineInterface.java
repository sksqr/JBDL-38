package com.gfg;

import java.util.Date;
import java.util.List;

public interface AirlineInterface {

    default List<Flight> getFlights(String src, String des, Date date){
        System.out.println("Default method");
        return null;
    }

    List<Flight> getFlights(String src, String des, Date date, String airline);


}
