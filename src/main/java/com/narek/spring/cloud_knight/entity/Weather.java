package com.narek.spring.cloud_knight.entity;


import java.util.HashMap;
import java.util.Map;

public class Weather {


    private int cod;

    private Map<String, Double> main = new HashMap<String, Double>();


    public Map<String, Double> getMain() {
        return main;
    }

    public void setMain(Map<String, Double> main) {
        this.main = main;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
