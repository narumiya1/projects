package com.eijun.project.model;

import com.google.gson.annotations.SerializedName;

public class Staats {

    @SerializedName("team")
    private Team team;

    @SerializedName("player")
    private Player player;

    @SerializedName("home_team")
    private HomeTeam home_team;

    @SerializedName("home_team")
    private VisitorTeam visitorTeam;



}
