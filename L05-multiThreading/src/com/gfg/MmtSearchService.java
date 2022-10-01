package com.gfg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class MmtSearchService {

    List<AirlineFlightSearchInterface> flightSearchServiceList;

    ExecutorService executorService;

    public MmtSearchService(List<AirlineFlightSearchInterface> flightSearchServiceList) {
        this.flightSearchServiceList = flightSearchServiceList;
        int  corePoolSize  =    5;
        int  maxPoolSize   =   10;
        long keepAliveTime = 5000;
        int queueSize=10;
         executorService =
                new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>(queueSize)
                );
    }


    public List<Flight> getAllFlightsBySrcDstData(String scr, String dst, Date date) throws InterruptedException, ExecutionException {

//        KeywordAnalyser keywordAnalyser = new UniqueKeywordAnalyser();
//        keywordAnalyser.recordKeyword(scr);
//        keywordAnalyser.recordKeyword(dst);

        List<Flight> allFlights = new ArrayList<>();
//        for(AirlineFlightSearchInterface flightSearchService : flightSearchServiceList){
//            allFlights.addAll(flightSearchService.getFlightsBySrcDstData(scr,dst,date));
//        }
//        return allFlights;



        List<Callable<List<Flight>>> callableList = new ArrayList<>();
        for(AirlineFlightSearchInterface airlineFlightSearch : flightSearchServiceList){
            callableList.add(new Callable<List<Flight>>() {
                @Override
                public List<Flight> call() throws Exception {
                    return airlineFlightSearch.getFlightsBySrcDstData(scr,dst,date);
                }
            });
        }
        List<Future<List<Flight>>> futureList = executorService.invokeAll(callableList);

        for(Future<List<Flight>> futureFlightList: futureList){
            allFlights.addAll(futureFlightList.get());
        }
        return allFlights;
    }
}
