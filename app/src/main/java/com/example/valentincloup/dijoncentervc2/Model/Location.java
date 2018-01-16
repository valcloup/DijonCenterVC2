package com.example.valentincloup.dijoncentervc2.Model;

/**
 * Created by Valentin CLOUP on 20/09/2017.
 */

public class Location
{
    private String adresse;
    private String postalCode;
    private String city;

    public Location(){}

    public Location(String adresse, String postalCode, String city) {
        this.adresse = adresse;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
