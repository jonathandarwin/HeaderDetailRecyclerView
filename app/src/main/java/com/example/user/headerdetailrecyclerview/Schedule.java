package com.example.user.headerdetailrecyclerview;

import android.app.admin.DeviceAdminInfo;

/**
 * Created by User on 3/3/2019.
 */

public class Schedule implements ISchedule{

    protected String description;
    protected String date;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int getType() {
        return DETAIL;
    }
}
