package com.askeledz.pages;

public class Country implements Comparable<Country> {

    private String countryName;
    private float gdp;
    private String population;
    private float co2;

    public Country() {
        super();
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getGdp() {
        return gdp;
    }

    public void setGdp(float gdp) {
        this.gdp = gdp;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public float getCo2() {
        return co2;
    }

    public void setCo2(float co2) {
        this.co2 = co2;
    }

    public int compareTo(Country o) {
        // TODO Auto-generated method stub
        return 0;
    }

}