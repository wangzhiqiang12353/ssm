package com.ytc.model;

public class MovieYear {
    private Integer yearid;

    private String yearname;

    public Integer getYearid() {
        return yearid;
    }

    public void setYearid(Integer yearid) {
        this.yearid = yearid;
    }

    public String getYearname() {
        return yearname;
    }

    public void setYearname(String yearname) {
        this.yearname = yearname == null ? null : yearname.trim();
    }
}