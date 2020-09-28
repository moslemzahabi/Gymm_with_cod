package com.example.gym_frag_db2.education;

public class EducationData {
    private int imagid;
    private String text;

    public EducationData(int imagid, String text) {
        this.imagid = imagid;
        this.text = text;
    }

    public int getImagid() {
        return imagid;
    }

    public void setImagid(int imagid) {
        this.imagid = imagid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
