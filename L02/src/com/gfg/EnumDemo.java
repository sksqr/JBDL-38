package com.gfg;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class EnumDemo {

    public static void main(String[] args) {
        System.out.println(JobType.FULLTIME instanceof JobType);

        Scanner sc = new Scanner(System.in);
        String day = sc.nextLine();
        WeekDay weekDay = null;
        if(day.equalsIgnoreCase("SUN")){
            weekDay = WeekDay.SUNDAY;
        }

        Iterator<WeekDay> iterator =  Arrays.stream(WeekDay.values()).iterator();
        while (iterator.hasNext()){
            WeekDay temp = iterator.next();
            System.out.println(temp.getDdd());
            System.out.println(temp.name());
        }


        WeekDay.SUNDAY.getRemainingDay(WeekDay.THURSDAY);

    }
}
