package com.example.chit.myapplication.com.example.chit.myapplication.model;

import java.util.List;

/**
 * Created by Chit on 3/8/2015.
 */
public class TxtForecast {

    private String date;

    private List<ForecastDay> forecastday;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ForecastDay> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<ForecastDay> forecastday) {
        this.forecastday = forecastday;
    }

    @Override
    public String toString() {
        return "TxtForecast{" +
                "date='" + date + '\'' +
                ", forecastday=" + forecastday +
                '}';
    }
}

