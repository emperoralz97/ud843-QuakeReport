package com.example.android.quakereport;

public class QuakeReportDesign {
    private double mag;
    private String region, time, date, url;
    QuakeReportDesign(double magnitude, String region, String date, String time, String url){
        mag = magnitude;
        this.region = region;
        this.date = date;
        this.time = time;
        this.url = url;
    }

    public double getMag(){return mag;}
    public String getRegion(){return region;}
    public String getTime(){return time;}
    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }
}
