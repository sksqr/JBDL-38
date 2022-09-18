package com.gfg;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PolymorphismDEmo {

    public static void main(String[] args) {

        AirlineInterface airlineInterface1 = new YatraProxyAirline();
        airlineInterface1.getFlights("","" ,new Date());


        AirlineInterface airlineInterface = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter location:");
        String loc = scanner.nextLine();

        System.out.println("Enter airline:");
        String airline = scanner.nextLine();

        if(loc.equals("india")){
            airlineInterface = new YatraProxyAirline();
            if(airline.isEmpty()){
                airlineInterface.getFlights("","" ,new Date());
            }
            else{
                airlineInterface.getFlights("","" ,new Date(),airline);
            }
        }
        else{
            airlineInterface = new EaseMyTripAirline();
            airlineInterface.getFlights("","" ,new Date());
        }

       // airlineInterface.getFlights("","" ,new Date());

    }
}
