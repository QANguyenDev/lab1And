package com.example.lab1_ph44183.Model;

public class ModelCat {
    private int id_cat;
    private String catname;

    public ModelCat(int id_cat, String catname) {
        this.id_cat = id_cat;
        this.catname = catname;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }
}
