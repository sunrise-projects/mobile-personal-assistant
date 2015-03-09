package com.example.chit.myapplication.com.example.chit.myapplication.model;

/**
 * Created by Chit on 3/8/2015.
 */
public class BaseForecast {

    private Response response;
    private Forecast forecast;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "BaseForecast{" +
                "response=" + response +
                ", forecast=" + forecast +
                '}';
    }
}
