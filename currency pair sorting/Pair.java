package com.company;

/**
 * Created by Ксения on 10.11.2016.
 */

/*
каждую строку входного файла будем рассматривать как экземпляр класса Pair
 */

public class Pair {

    private String date;
    public String getDate() {
        return this.date;
    }

    private String time;
    public String getTime() {
        return this.time;
    }

    private double open;
    public double getOpen() {
        return this.open;
    }

    private double high;
    public double getHigh() {
        return this.high;
    }

    private double low;
    public double getLow() {
        return this.low;
    }

    private double close;
    public double getClose() {
        return this.close;
    }

    private int vol;
    public int getVol() {
        return this.vol;
    }
    public void setVol(int vol) {
        this.vol = vol;
    }

    private boolean bijectionFlag;
    public boolean getBijectionFlag() {
        return this.bijectionFlag;
    }
    public void setBijectionFlag(boolean flag) {
        this.bijectionFlag = flag;
    }

    public Pair(String date, String time, double open, double high, double low, double close, int vol) {
        this.date = date;
        this.time = time;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.vol = vol;
        this.bijectionFlag = false;
    }

    public Pair(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public Pair() {

    }

}
