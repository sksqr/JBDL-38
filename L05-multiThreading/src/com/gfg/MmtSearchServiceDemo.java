package com.gfg;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MmtSearchServiceDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<AirlineFlightSearchInterface> airlineFlightSearchInterfaces = new ArrayList<>();
        airlineFlightSearchInterfaces.add(new IndigoFlightSearchService());
        airlineFlightSearchInterfaces.add(new AirIndiaFlightsearchService());
        MmtSearchService mmtSearchService = new MmtSearchService(airlineFlightSearchInterfaces);

        List<Flight> allFlights = mmtSearchService.getAllFlightsBySrcDstData("src", "dst",new Date());

    }
}
