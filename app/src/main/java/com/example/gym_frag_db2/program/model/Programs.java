package com.example.gym_frag_db2.program.model;

public class Programs {
  private   String Programsname;
  private   int id;

    public Programs( int id,String programsname) {
        Programsname = programsname;
        this.id = id;
    }

    public String getProgramsname() {
        return Programsname;
    }

    public void setProgramsname(String programsname) {
        Programsname = programsname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
