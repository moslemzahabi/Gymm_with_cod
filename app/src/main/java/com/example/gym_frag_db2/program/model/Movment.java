package com.example.gym_frag_db2.program.model;

public class Movment {

    private int id;
    private int day;
    private int mov;
    private int submov;
    private int movset;
    private int minmov;
    private int maxmov;

    public Movment(int id, int day, int mov, int submov, int movset, int minmov, int maxmov) {
        this.id = id;
        this.day = day;
        this.mov = mov;
        this.submov = submov;
        this.movset = movset;
        this.minmov = minmov;
        this.maxmov = maxmov;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getMovset() {
        return movset;
    }

    public void setMovset(int movset) {
        this.movset = movset;
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
