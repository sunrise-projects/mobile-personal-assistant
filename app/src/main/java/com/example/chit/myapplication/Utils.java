package com.example.chit.myapplication;

import android.net.Uri;

import com.example.chit.myapplication.com.example.chit.myapplication.model.BaseForecast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Chit on 3/8/2015.
 */
public class Utils {

    public static void main(String args[]) {
        //System.out.println(getCurrentTime());

        System.out.println(readJSONString());

    }

    public static String getCurrentTime() {
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("h m a");
        return "The current time is "+fmt.print(dt);
    }

    public static BaseForecast readSampleForecastObject() {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(SAMPLE_JSON, BaseForecast.class);
    }

    public static String readJSONString() {
        Gson gson = new GsonBuilder().create();
        BaseForecast baseForecast=gson.fromJson(SAMPLE_JSON, BaseForecast.class);
        return baseForecast.toString();
    }


    private static final String SAMPLE_JSON = "{\"response\":{\"version\":\"0.1\",\"termsofService\":\"http://www.wunderground.com/weather/api/d/terms.html\",\"features\":{\"forecast\":1}},\"forecast\":{\"txt_forecast\":{\"date\":\"8:42 PM CDT\",\"forecastday\":[{\"period\":0,\"icon\":\"partlycloudy\",\"icon_url\":\"http://icons.wxug.com/i/c/k/partlycloudy.gif\",\"title\":\"Sunday\",\"fcttext\":\"Partly cloudy. Lows overnight in the low 30s.\",\"fcttext_metric\":\"Partly cloudy. Low -1C.\",\"pop\":\"0\"},{\"period\":1,\"icon\":\"nt_partlycloudy\",\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_partlycloudy.gif\",\"title\":\"Sunday Night\",\"fcttext\":\"Partly cloudy skies. Low 31F. Winds WNW at 5 to 10 mph.\",\"fcttext_metric\":\"Clear to partly cloudy. Low -1C. Winds W at 10 to 15 km/h.\",\"pop\":\"0\"},{\"period\":2,\"icon\":\"clear\",\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\"title\":\"Monday\",\"fcttext\":\"Sunny. High 47F. Winds SSW at 5 to 10 mph.\",\"fcttext_metric\":\"A mainly sunny sky. High 8C. Winds SSW at 10 to 15 km/h.\",\"pop\":\"0\"},{\"period\":3,\"icon\":\"nt_fog\",\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_fog.gif\",\"title\":\"Monday Night\",\"fcttext\":\"Partly cloudy skies early will give way to considerable cloudiness and fog after midnight. Low 34F. Winds light and variable.\",\"fcttext_metric\":\"Partly cloudy skies early, then becoming foggy and damp later at night. Low 1C. Winds S at 10 to 15 km/h.\",\"pop\":\"10\"},{\"period\":4,\"icon\":\"partlycloudy\",\"icon_url\":\"http://icons.wxug.com/i/c/k/partlycloudy.gif\",\"title\":\"Tuesday\",\"fcttext\":\"Cloudy early with partial sunshine expected late. High 53F. Winds SW at 5 to 10 mph.\",\"fcttext_metric\":\"Cloudy skies early will become partly cloudy later in the day. High 12C. Winds SW at 10 to 15 km/h.\",\"pop\":\"10\"},{\"period\":5,\"icon\":\"nt_partlycloudy\",\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_partlycloudy.gif\",\"title\":\"Tuesday Night\",\"fcttext\":\"A few clouds from time to time. Low 39F. Winds W at 5 to 10 mph.\",\"fcttext_metric\":\"Partly cloudy. Low 4C. Winds W at 10 to 15 km/h.\",\"pop\":\"10\"},{\"period\":6,\"icon\":\"clear\",\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\"title\":\"Wednesday\",\"fcttext\":\"Sunny skies. High 46F. Winds NNE at 5 to 10 mph.\",\"fcttext_metric\":\"A mainly sunny sky. High 9C. Winds NNE at 10 to 15 km/h.\",\"pop\":\"10\"},{\"period\":7,\"icon\":\"nt_clear\",\"icon_url\":\"http://icons.wxug.com/i/c/k/nt_clear.gif\",\"title\":\"Wednesday Night\",\"fcttext\":\"Clear. Low 33F. Winds light and variable.\",\"fcttext_metric\":\"Clear skies. Low 1C. Winds light and variable.\",\"pop\":\"0\"}]},\"simpleforecast\":{\"forecastday\":[{\"date\":{\"epoch\":\"1425859200\",\"pretty\":\"7:00 PM CDT on March 08, 2015\",\"day\":8,\"month\":3,\"year\":2015,\"yday\":66,\"hour\":19,\"min\":\"00\",\"sec\":0,\"isdst\":\"1\",\"monthname\":\"March\",\"monthname_short\":\"Mar\",\"weekday_short\":\"Sun\",\"weekday\":\"Sunday\",\"ampm\":\"PM\",\"tz_short\":\"CDT\",\"tz_long\":\"America/Chicago\"},\"period\":1,\"high\":{\"fahrenheit\":\"43\",\"celsius\":\"6\"},\"low\":{\"fahrenheit\":\"31\",\"celsius\":\"-1\"},\"conditions\":\"Partly Cloudy\",\"icon\":\"partlycloudy\",\"icon_url\":\"http://icons.wxug.com/i/c/k/partlycloudy.gif\",\"skyicon\":\"\",\"pop\":0,\"qpf_allday\":{\"in\":0.00,\"mm\":0},\"qpf_day\":{\"in\":null,\"mm\":null},\"qpf_night\":{\"in\":0.00,\"mm\":0},\"snow_allday\":{\"in\":0.0,\"cm\":0.0},\"snow_day\":{\"in\":null,\"cm\":null},\"snow_night\":{\"in\":0.0,\"cm\":0.0},\"maxwind\":{\"mph\":10,\"kph\":16,\"dir\":\"\",\"degrees\":0},\"avewind\":{\"mph\":2,\"kph\":2,\"dir\":\"West\",\"degrees\":262},\"avehumidity\":68,\"maxhumidity\":0,\"minhumidity\":0},{\"date\":{\"epoch\":\"1425945600\",\"pretty\":\"7:00 PM CDT on March 09, 2015\",\"day\":9,\"month\":3,\"year\":2015,\"yday\":67,\"hour\":19,\"min\":\"00\",\"sec\":0,\"isdst\":\"1\",\"monthname\":\"March\",\"monthname_short\":\"Mar\",\"weekday_short\":\"Mon\",\"weekday\":\"Monday\",\"ampm\":\"PM\",\"tz_short\":\"CDT\",\"tz_long\":\"America/Chicago\"},\"period\":2,\"high\":{\"fahrenheit\":\"47\",\"celsius\":\"8\"},\"low\":{\"fahrenheit\":\"34\",\"celsius\":\"1\"},\"conditions\":\"Clear\",\"icon\":\"clear\",\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\"skyicon\":\"\",\"pop\":0,\"qpf_allday\":{\"in\":0.00,\"mm\":0},\"qpf_day\":{\"in\":0.00,\"mm\":0},\"qpf_night\":{\"in\":0.00,\"mm\":0},\"snow_allday\":{\"in\":0.0,\"cm\":0.0},\"snow_day\":{\"in\":0.0,\"cm\":0.0},\"snow_night\":{\"in\":0.0,\"cm\":0.0},\"maxwind\":{\"mph\":10,\"kph\":16,\"dir\":\"SSW\",\"degrees\":197},\"avewind\":{\"mph\":6,\"kph\":10,\"dir\":\"SSW\",\"degrees\":197},\"avehumidity\":66,\"maxhumidity\":0,\"minhumidity\":0},{\"date\":{\"epoch\":\"1426032000\",\"pretty\":\"7:00 PM CDT on March 10, 2015\",\"day\":10,\"month\":3,\"year\":2015,\"yday\":68,\"hour\":19,\"min\":\"00\",\"sec\":0,\"isdst\":\"1\",\"monthname\":\"March\",\"monthname_short\":\"Mar\",\"weekday_short\":\"Tue\",\"weekday\":\"Tuesday\",\"ampm\":\"PM\",\"tz_short\":\"CDT\",\"tz_long\":\"America/Chicago\"},\"period\":3,\"high\":{\"fahrenheit\":\"53\",\"celsius\":\"12\"},\"low\":{\"fahrenheit\":\"39\",\"celsius\":\"4\"},\"conditions\":\"Partly Cloudy\",\"icon\":\"partlycloudy\",\"icon_url\":\"http://icons.wxug.com/i/c/k/partlycloudy.gif\",\"skyicon\":\"\",\"pop\":10,\"qpf_allday\":{\"in\":0.00,\"mm\":0},\"qpf_day\":{\"in\":0.00,\"mm\":0},\"qpf_night\":{\"in\":0.00,\"mm\":0},\"snow_allday\":{\"in\":0.0,\"cm\":0.0},\"snow_day\":{\"in\":0.0,\"cm\":0.0},\"snow_night\":{\"in\":0.0,\"cm\":0.0},\"maxwind\":{\"mph\":10,\"kph\":16,\"dir\":\"SW\",\"degrees\":215},\"avewind\":{\"mph\":8,\"kph\":13,\"dir\":\"SW\",\"degrees\":215},\"avehumidity\":70,\"maxhumidity\":0,\"minhumidity\":0},{\"date\":{\"epoch\":\"1426118400\",\"pretty\":\"7:00 PM CDT on March 11, 2015\",\"day\":11,\"month\":3,\"year\":2015,\"yday\":69,\"hour\":19,\"min\":\"00\",\"sec\":0,\"isdst\":\"1\",\"monthname\":\"March\",\"monthname_short\":\"Mar\",\"weekday_short\":\"Wed\",\"weekday\":\"Wednesday\",\"ampm\":\"PM\",\"tz_short\":\"CDT\",\"tz_long\":\"America/Chicago\"},\"period\":4,\"high\":{\"fahrenheit\":\"46\",\"celsius\":\"8\"},\"low\":{\"fahrenheit\":\"33\",\"celsius\":\"1\"},\"conditions\":\"Clear\",\"icon\":\"clear\",\"icon_url\":\"http://icons.wxug.com/i/c/k/clear.gif\",\"skyicon\":\"\",\"pop\":10,\"qpf_allday\":{\"in\":0.00,\"mm\":0},\"qpf_day\":{\"in\":0.00,\"mm\":0},\"qpf_night\":{\"in\":0.00,\"mm\":0},\"snow_allday\":{\"in\":0.0,\"cm\":0.0},\"snow_day\":{\"in\":0.0,\"cm\":0.0},\"snow_night\":{\"in\":0.0,\"cm\":0.0},\"maxwind\":{\"mph\":10,\"kph\":16,\"dir\":\"NNE\",\"degrees\":28},\"avewind\":{\"mph\":7,\"kph\":11,\"dir\":\"NNE\",\"degrees\":28},\"avehumidity\":66,\"maxhumidity\":0,\"minhumidity\":0}]}}}";

}
