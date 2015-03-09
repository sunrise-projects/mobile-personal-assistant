package com.example.chit.myapplication.com.example.chit.myapplication.model;

import java.util.List;

/**
 * Created by Chit on 3/8/2015.
 */
public class    SimpleForecast {

    private List<ForecastDayMore> forecastday;

    public List<ForecastDayMore> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<ForecastDayMore> forecastday) {
        this.forecastday = forecastday;
    }

    @Override
    public String toString() {
        return "SimpleForecast{" +
                "forecastday=" + forecastday +
                '}';
    }
}
