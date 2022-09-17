package com.gfg;

public abstract class TataCar implements GovtNomsForCar, StateGovtNomsForCar{

    public String type="";

    @Override
    public String getBrand(){
        return "Tata";
    }
}
