package com.example.lab1_ph44183.Model;

public class ModelSP {
    private int id_sp;
    private String tensp;
    private double giasp;
    private int id_cat;

    public ModelSP() {
    }

    public ModelSP(int id_sp, String tensp, double giasp, int id_cat) {
        this.id_sp = id_sp;
        this.tensp = tensp;
        this.giasp = giasp;
        this.id_cat = id_cat;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public double getGiasp() {
        return giasp;
    }

    public void setGiasp(double giasp) {
        this.giasp = giasp;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }
}
