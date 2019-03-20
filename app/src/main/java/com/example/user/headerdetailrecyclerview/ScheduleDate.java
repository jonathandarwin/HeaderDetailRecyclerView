package com.example.user.headerdetailrecyclerview;

/**
 * Created by User on 3/3/2019.
 */

public class ScheduleDate implements ISchedule {

    protected String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int getType() {
        return HEADER;
    }
}
