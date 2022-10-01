package com.gfg;

import java.util.Date;
import java.util.List;

public interface AirlineFlightSearchInterface {

    List<Flight> getFlightsBySrcDstData(String scr, String dst, Date date);
}
