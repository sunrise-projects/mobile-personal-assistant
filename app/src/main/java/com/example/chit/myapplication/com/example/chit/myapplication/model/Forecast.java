package com.example.chit.myapplication.com.example.chit.myapplication.model;

/**
 * Created by Chit on 3/8/2015.
 */
public class Forecast {

    private TxtForecast txt_forecast;

    private SimpleForecast simpleforecast;

    public SimpleForecast getSimpleforecast() {
        return simpleforecast;
    }

    public void setSimpleforecast(SimpleForecast simpleforecast) {
        this.simpleforecast = simpleforecast;
    }

    public TxtForecast getTxt_forecast() {
        return txt_forecast;
    }

    public void setTxt_forecast(TxtForecast txt_forecast) {
        this.txt_forecast = txt_forecast;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "txt_forecast=" + txt_forecast +
                ", simpleforecast=" + simpleforecast +
                '}';
    }
}
