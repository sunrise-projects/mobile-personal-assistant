package com.example.chit.myapplication.com.example.chit.myapplication.model;

/**
 * Created by Chit on 3/8/2015.
 */
public class MphKph {

    private Integer mph;
    private Integer kph;
    private String dir;
    private Integer degrees;

    public Integer getMph() {
        return mph;
    }

    public void setMph(Integer mph) {
        this.mph = mph;
    }

    public Integer getKph() {
        return kph;
    }

    public void setKph(Integer kph) {
        this.kph = kph;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public Integer getDegrees() {
        return degrees;
    }

    public void setDegrees(Integer degrees) {
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        return "MphKph{" +
                "mph=" + mph +
                ", kph=" + kph +
                ", dir='" + dir + '\'' +
                ", degrees=" + degrees +
                '}';
    }
}
