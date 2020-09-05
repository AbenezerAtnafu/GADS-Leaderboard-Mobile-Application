package com.example.gads_leaderboard_mobile_application;

import java.net.URL;

public class Leader {

    private String name;
    private int hours;
    private String country;
    private String badgeUrl;

    public Leader(String name, int hours, String country, String badgeUrl){
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

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

    public String getBadge() {
        return badgeUrl;
    }

    public void setBadge(String badge) {
        this.badgeUrl = badge;
    }
}
