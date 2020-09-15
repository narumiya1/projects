package com.eijun.project.model;

import com.google.gson.annotations.SerializedName;

public class Player {
    @SerializedName("id")
    private String id;

    @SerializedName("first_name")
    private String first_name;


    @SerializedName("last_name")
    private String last_name;

    @SerializedName("position")
    private String position;

    @SerializedName("team")
    private Team teamz;

    public Player(String id, String first_name, String last_name, String position, Team team) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.position = position;
        this.teamz = team ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Team getTeamz() {
        return teamz;
    }
}
