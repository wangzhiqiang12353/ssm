package com.ytc.model;

public class Adress {
    private Integer adressid;

    private String adressname;

    public Integer getAdressid() {
        return adressid;
    }

    public void setAdressid(Integer adressid) {
        this.adressid = adressid;
    }

    public String getAdressname() {
        return adressname;
    }

    public void setAdressname(String adressname) {
        this.adressname = adressname == null ? null : adressname.trim();
    }
}