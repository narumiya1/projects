package com.eijun.project.model;

import com.google.gson.annotations.SerializedName;

public class Games {
    @SerializedName("id")
    private String id;

    @SerializedName("home_team_score")
    private String home_team_score;

    @SerializedName("away_team_score")
    private String away_team_score;

    @SerializedName("date")
    private String date;

    @SerializedName("status")
    private String status;

    @SerializedName("home_team")
    private HomeTeam home_team;

    @SerializedName("visitor_team")
    private VisitorTeam visitor_team;


    public Games(String id, String home_team_score, String away_team_score, String date, String status, VisitorTeam visitor_team, HomeTeam home_team) {
        this.id = id;
        this.home_team_score = home_team_score;
        this.away_team_score = away_team_score;
        this.date=date;
        this.status=status;
        this.home_team= home_team;
        this.visitor_team= visitor_team;

    }

    public HomeTeam getHome_team() {
        return home_team;
    }

    public VisitorTeam getVisitor_team() {
        return visitor_team;
    }

    public String getId() {
        return id;
    }

    public String getHome_team_score() {
        return home_team_score;
    }

    public String getAway_team_score() {
        return away_team_score;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
