package com.example.gym_frag_db2.testActivitis;

public class Movtest {
    private int day;
    private  int mov;
    private  int submov;
    private  int set;
    private  int minmov;
    private  int maxmov;

    public Movtest(int day, int mov, int submov, int set, int minmov, int maxmov) {
        this.day = day;
        this.mov = mov;
        this.submov = submov;
        this.set = set;
        this.minmov = minmov;
        this.maxmov = maxmov;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMov() {
        return mov;
    }

    public void setMov(int mov) {
        this.mov = mov;
    }

    public int getSubmov() {
        return submov;
    }

    public void setSubmov(int submov) {
        this.submov = submov;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public int getMinmov() {
        return minmov;
    }

    public void setMinmov(int minmov) {
        this.minmov = minmov;
    }

    public int getMaxmov() {
        return maxmov;
    }

    public void setMaxmov(int maxmov) {
        this.maxmov = maxmov;
    }
}
