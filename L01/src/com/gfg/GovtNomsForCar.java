package com.gfg;

public interface GovtNomsForCar {


    public String getPUC();

    public String getRC();

    public String getInsuarance();

    public String getBrand();

    default public String getLocation(){
        return "12324";
    }

}
