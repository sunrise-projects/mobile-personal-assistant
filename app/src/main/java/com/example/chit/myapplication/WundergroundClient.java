package com.example.chit.myapplication;

/*
 * Copyright (C) 2012 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.example.chit.myapplication.com.example.chit.myapplication.model.BaseForecast;
import com.example.chit.myapplication.com.example.chit.myapplication.model.Forecast;
import com.example.chit.myapplication.com.example.chit.myapplication.model.ForecastDay;
import com.example.chit.myapplication.com.example.chit.myapplication.model.ForecastDayMore;
import com.example.chit.myapplication.com.example.chit.myapplication.model.SimpleForecast;
import com.example.chit.myapplication.com.example.chit.myapplication.model.TxtForecast;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;

public class WundergroundClient {
    private static final String API_URL = "http://api.wunderground.com";

    static class Contributor {
        String login;
        int contributions;
    }

    interface  Wunderground {
        @GET("/api/{token}/forecast/q/{state}/{city}.json")
        BaseForecast getForecast(
                @Path("token") String token,
                @Path("state") String state,
                @Path("city") String city
        );
    }

    public BaseForecast getForecast() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();
        Wunderground  wunderground = restAdapter.create( Wunderground.class);
        //return wunderground.getForecast("b6cf8207da248fa2", "IL", "Chicago");
        return wunderground.getForecast("b6cf8207da248fa2", "IL", "Hoffman_Estates");

    }


    private StringBuilder forecastToString(BaseForecast forecastObj, int wholeday, int day, int night) {


        Forecast forecast = forecastObj.getForecast();

        //=====================================
        TxtForecast txtForecast = forecast.getTxt_forecast();
        String forecastDate = txtForecast.getDate();

        StringBuilder str = new StringBuilder();
        //str.append("Current time is "+forecastDate);

        ForecastDay forecastDay = txtForecast.getForecastday().get(day);
        //str.append(" . ");
        str.append(forecastDay.getTitle());
        str.append(" . ");
        str.append(forecastDay.getFcttext());

        ForecastDay forecastNight = txtForecast.getForecastday().get(night);
        str.append("  ");
        str.append(forecastNight.getTitle());
        str.append(" . ");
        str.append(forecastNight.getFcttext());

        //=====================================
        SimpleForecast simpleForecast = forecast.getSimpleforecast();
        ForecastDayMore forecastDayMore = simpleForecast.getForecastday().get(wholeday);
        str.append(" High temperature is ");
        str.append(forecastDayMore.getHigh().getFahrenheit());
        str.append(" degree, ");
        str.append("And low temperature is ");
        str.append(forecastDayMore.getLow().getFahrenheit());
        str.append(" degree. ");

        return str;
    }

    public String getFourDayForecast() {
        WundergroundClient cl = new WundergroundClient();
        BaseForecast forecastObj = cl.getForecast();
        //BaseForecast forecastObj = Utils.readSampleForecastObject();
        int j=0;
        int k=0;
        StringBuilder str = new StringBuilder();
        for (int i=0;i<4;i++) {
            k=j+1;
            System.out.println(""+i+","+j+","+k+"");
            str.append(forecastToString(forecastObj, i, j, k));
            j=j+2;
        }
        return "This weeks forecast. "+str.toString();
    }


    public String getTodayForecast() {
        WundergroundClient cl = new WundergroundClient();
        BaseForecast forecastObj = cl.getForecast();
        //BaseForecast forecastObj = Utils.readSampleForecastObject();
        StringBuilder str = forecastToString(forecastObj, 0, 0, 1);
        return "Today's forecast. "+str.toString();
    }


    public static void main(String... args) {
//        WundergroundClient cl = new WundergroundClient();
//        BaseForecast forecast = cl.getForecast();
//        System.out.println(forecast.toString());

        WundergroundClient cl = new WundergroundClient();
        //System.out.println(cl.getTodayForecast());
        System.out.println(cl.getFourDayForecast());


    }
}