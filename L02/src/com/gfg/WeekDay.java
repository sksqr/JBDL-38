package com.gfg;

public enum WeekDay implements RemaingDaysFunctionality{

    SUNDAY("SUN"), MONDAY("MON"), TUESDAY("TUE"), WEDNESDAY(("TUE")), THURSDAY("THU"), FRIDAY("FRI"), SATURDAY("SAT");

    private String ddd;

    private WeekDay(String ddd) {
        this.ddd = ddd;
    }

    public String getDdd() {
        return ddd;
    }

    @Override
    public int getRemainingDay(WeekDay weekDay) {
        return this.ordinal() - weekDay.ordinal();
    }
}
