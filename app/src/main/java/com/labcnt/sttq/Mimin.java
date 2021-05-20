package com.labcnt.sttq;

public class Mimin {
    String id;
    String Aktifasi;
    String ValueA;

    public Mimin() {

    }

    public Mimin(String id, String aktifasi, String valueA) {
        this.id = id;
        this.Aktifasi = aktifasi;
        this.ValueA = valueA;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAktifasi() {
        return Aktifasi;
    }

    public void setAktifasi(String aktifasi) {
        Aktifasi = aktifasi;
    }

    public String getValueA() {
        return ValueA;
    }

    public void setValueA(String valueA) {
        ValueA = valueA;
    }
}
