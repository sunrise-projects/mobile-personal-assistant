package com.example.chit.myapplication.com.example.chit.myapplication.model;

/**
 * Created by Chit on 3/8/2015.
 */
public class ForecastDay {

    private Integer period;
    private String icon;
    private String icon_url;
    private String title;
    private String fcttext;
    private String fcttext_metric;
    private Integer pop;

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFcttext() {
        return fcttext;
    }

    public void setFcttext(String fcttext) {
        this.fcttext = fcttext;
    }

    public String getFcttext_metric() {
        return fcttext_metric;
    }

    public void setFcttext_metric(String fcttext_metric) {
        this.fcttext_metric = fcttext_metric;
    }

    public Integer getPop() {
        return pop;
    }

    public void setPop(Integer pop) {
        this.pop = pop;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "ForecastDay{" +
                "period=" + period +
                ", icon='" + icon + '\'' +
                ", icon_url='" + icon_url + '\'' +
                ", title='" + title + '\'' +
                ", fcttext='" + fcttext + '\'' +
                ", fcttext_metric='" + fcttext_metric + '\'' +
                ", pop=" + pop +
                '}';
    }
}
