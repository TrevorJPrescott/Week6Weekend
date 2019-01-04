package com.trevorpc.myapplication.models;

import android.location.Location;

public class User {
    Double mWeek;
    Double mDay;
    Location mLocation;

    public User(Double mWeek, Double mDay, Location mLocation) {
        this.mWeek = mWeek;
        this.mDay = mDay;
        this.mLocation = mLocation;
    }

    public User() {}


    public Double getmWeek() {
        return mWeek;
    }

    public void setmWeek(Double mWeek) {
        this.mWeek = mWeek;
    }

    public Double getmDay() {
        return mDay;
    }

    public void setmDay(Double mDay) {
        this.mDay = mDay;
    }

    public Location getmLocation() {
        return mLocation;
    }

    public void setmLocation(Location mLocation) {
        this.mLocation = mLocation;
    }
}
