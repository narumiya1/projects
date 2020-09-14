package com.eijun.project.model;

import com.google.gson.annotations.SerializedName;

public class HomAway {
    @SerializedName("home_team_name")
    private String home_team_name;

    @SerializedName("away_team_name")
    private String away_team_name;

    public String getHome_team_name() {
        return home_team_name;
    }

    public String getAway_team_name() {
        return away_team_name;
    }
}
