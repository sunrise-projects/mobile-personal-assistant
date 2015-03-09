package com.example.chit.myapplication.com.example.chit.myapplication.model;

/**
 * Created by Chit on 3/8/2015.
 */
public class Date {

    private String epoch;
    private String pretty;
    private Integer day;
    private Integer month;
    private Integer year;
    private Integer yday;
    private Integer hour;
    private String min;
    private Integer sec;
    private String isdst;
    private String monthname;
    private String monthname_short;
    private String weekday_short;
    private String weekday;
    private String ampm;
    private String tz_short;
    private String tz_long;

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public String getPretty() {
        return pretty;
    }

    public void setPretty(String pretty) {
        this.pretty = pretty;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYday() {
        return yday;
    }

    public void setYday(Integer yday) {
        this.yday = yday;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public Integer getSec() {
        return sec;
    }

    public void setSec(Integer sec) {
        this.sec = sec;
    }

    public String getIsdst() {
        return isdst;
    }

    public void setIsdst(String isdst) {
        this.isdst = isdst;
    }

    public String getMonthname() {
        return monthname;
    }

    public void setMonthname(String monthname) {
        this.monthname = monthname;
    }

    public String getMonthname_short() {
        return monthname_short;
    }

    public void setMonthname_short(String monthname_short) {
        this.monthname_short = monthname_short;
    }

    public String getWeekday_short() {
        return weekday_short;
    }

    public void setWeekday_short(String weekday_short) {
        this.weekday_short = weekday_short;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    public String getTz_short() {
        return tz_short;
    }

    public void setTz_short(String tz_short) {
        this.tz_short = tz_short;
    }

    public String getTz_long() {
        return tz_long;
    }

    public void setTz_long(String tz_long) {
        this.tz_long = tz_long;
    }

    @Override
    public String toString() {
        return "Date{" +
                "epoch='" + epoch + '\'' +
                ", pretty='" + pretty + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", yday=" + yday +
                ", hour=" + hour +
                ", min='" + min + '\'' +
                ", sec=" + sec +
                ", isdst='" + isdst + '\'' +
                ", monthname='" + monthname + '\'' +
                ", monthname_short='" + monthname_short + '\'' +
                ", weekday_short='" + weekday_short + '\'' +
                ", weekday='" + weekday + '\'' +
                ", ampm='" + ampm + '\'' +
                ", tz_short='" + tz_short + '\'' +
                ", tz_long='" + tz_long + '\'' +
                '}';
    }
}
