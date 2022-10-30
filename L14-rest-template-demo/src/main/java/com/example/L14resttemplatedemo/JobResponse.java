package com.example.L14resttemplatedemo;

import com.fasterxml.jackson.annotation.JsonAlias;

public class JobResponse {

    @JsonAlias("TotalJobsCount")
    private String totalJobsCount;

    @JsonAlias("TotalVacanciesCount")
    private String totalVacanciesCount;


    public String getTotalJobsCount() {
        return totalJobsCount;
    }

    public void setTotalJobsCount(String totalJobsCount) {
        this.totalJobsCount = totalJobsCount;
    }

    public String getTotalVacanciesCount() {
        return totalVacanciesCount;
    }

    public void setTotalVacanciesCount(String totalVacanciesCount) {
        this.totalVacanciesCount = totalVacanciesCount;
    }
}
