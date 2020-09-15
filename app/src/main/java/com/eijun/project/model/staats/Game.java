package com.eijun.project.model.staats;

public class Game{
	private String date;
	private int homeTeamId;
	private int visitorTeamId;
	private int season;
	private String visitorTeamScore;
	private int id;
	private String homeTeamScore;

	public String getDate(){
		return date;
	}

	public int getHomeTeamId(){
		return homeTeamId;
	}

	public int getVisitorTeamId(){
		return visitorTeamId;
	}

	public int getSeason(){
		return season;
	}

	public String getVisitorTeamScore(){
		return visitorTeamScore;
	}

	public int getId(){
		return id;
	}

	public String getHomeTeamScore(){
		return homeTeamScore;
	}

	public Game(String date, int homeTeamId, int visitorTeamId, int season, String visitorTeamScore, int id, String homeTeamScore) {
		this.date = date;
		this.homeTeamId = homeTeamId;
		this.visitorTeamId = visitorTeamId;
		this.season = season;
		this.visitorTeamScore = visitorTeamScore;
		this.id = id;
		this.homeTeamScore = homeTeamScore;
	}
}
