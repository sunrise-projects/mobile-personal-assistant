package com.example.chit.myapplication.com.example.chit.myapplication.model;

/**
 * Created by Chit on 3/8/2015.
 */
public class ForecastDayMore {

    private Date date;
    private Integer period;
    private Temperature high;
    private Temperature low;
    private String conditions;
    private String icon;
    private String icon_url;
    private String sky_icon;
    private Integer pop;
    private InchesMm qpf_allday;
    private InchesMm qpf_day;
    private InchesMm qpf_night;
    private InchesCm snow_allday;
    private InchesCm snow_day;
    private InchesCm snow_night;
    private MphKph maxwind;
    private MphKph avewind;
    private Integer avehumidity;
    private Integer maxhumidity;
    private Integer minhumidity;

    public Temperature getHigh() {
        return high;
    }

    public void setHigh(Temperature high) {
        this.high = high;
    }

    public Temperature getLow() {
        return low;
    }

    public void setLow(Temperature low) {
        this.low = low;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getSky_icon() {
        return sky_icon;
    }

    public void setSky_icon(String sky_icon) {
        this.sky_icon = sky_icon;
    }

    public Integer getPop() {
        return pop;
    }

    public void setPop(Integer pop) {
        this.pop = pop;
    }

    public InchesMm getQpf_allday() {
        return qpf_allday;
    }

    public void setQpf_allday(InchesMm qpf_allday) {
        this.qpf_allday = qpf_allday;
    }

    public InchesMm getQpf_day() {
        return qpf_day;
    }

    public void setQpf_day(InchesMm qpf_day) {
        this.qpf_day = qpf_day;
    }

    public InchesMm getQpf_night() {
        return qpf_night;
    }

    public void setQpf_night(InchesMm qpf_night) {
        this.qpf_night = qpf_night;
    }
    public MphKph getMaxwind() {
        return maxwind;
    }

    public void setMaxwind(MphKph maxwind) {
        this.maxwind = maxwind;
    }

    public MphKph getAvewind() {
        return avewind;
    }

    public void setAvewind(MphKph avewind) {
        this.avewind = avewind;
    }

    public Integer getAvehumidity() {
        return avehumidity;
    }

    public void setAvehumidity(Integer avehumidity) {
        this.avehumidity = avehumidity;
    }

    public Integer getMaxhumidity() {
        return maxhumidity;
    }

    public void setMaxhumidity(Integer maxhumidity) {
        this.maxhumidity = maxhumidity;
    }

    public Integer getMinhumidity() {
        return minhumidity;
    }

    public void setMinhumidity(Integer minhumidity) {
        this.minhumidity = minhumidity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }


    public InchesCm getSnow_allday() {
        return snow_allday;
    }

    public void setSnow_allday(InchesCm snow_allday) {
        this.snow_allday = snow_allday;
    }

    public InchesCm getSnow_day() {
        return snow_day;
    }

    public void setSnow_day(InchesCm snow_day) {
        this.snow_day = snow_day;
    }

    public InchesCm getSnow_night() {
        return snow_night;
    }

    public void setSnow_night(InchesCm snow_night) {
        this.snow_night = snow_night;
    }

    @Override
    public String toString() {
        return "ForecastDayMore{" +
                "date=" + date +
                ", period=" + period +
                ", high=" + high +
                ", low=" + low +
                ", conditions='" + conditions + '\'' +
                ", icon='" + icon + '\'' +
                ", icon_url='" + icon_url + '\'' +
                ", sky_icon='" + sky_icon + '\'' +
                ", pop=" + pop +
                ", qpf_allday=" + qpf_allday +
                ", qpf_day=" + qpf_day +
                ", qpf_night=" + qpf_night +
                ", snow_allday=" + snow_allday +
                ", snow_day=" + snow_day +
                ", snow_night=" + snow_night +
                ", maxwind=" + maxwind +
                ", avewind=" + avewind +
                ", avehumidity=" + avehumidity +
                ", maxhumidity=" + maxhumidity +
                ", minhumidity=" + minhumidity +
                '}';
    }
}

