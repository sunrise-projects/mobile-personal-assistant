package com.example.chit.myapplication.com.example.chit.myapplication.model;

/**
 * Created by Chit on 3/8/2015.
 */
public class Temperature {

    private String fahrenheit;

    private String celsius;


    public String getCelsius() {
        return celsius;
    }

    public void setCelsius(String celsius) {
        this.celsius = celsius;
    }

    public String getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(String fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "fahrenheit='" + fahrenheit + '\'' +
                ", celsius='" + celsius + '\'' +
                '}';
    }

}
