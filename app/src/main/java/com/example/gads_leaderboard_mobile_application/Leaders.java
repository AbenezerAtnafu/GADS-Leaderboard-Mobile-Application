package com.example.gads_leaderboard_mobile_application;

import java.net.URL;

public class Leaders {

    private String name;
    private Integer hours;
    private String country;
    private URL badgeUrl;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public URL getBadge() {
        return badgeUrl;
    }

    public void setBadge(URL badge) {
        this.badgeUrl = badge;
    }
}
