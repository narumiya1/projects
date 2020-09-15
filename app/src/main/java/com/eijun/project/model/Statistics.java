package com.eijun.project.model;

import com.google.gson.annotations.SerializedName;

public class Statistics{
	private int blk;
	private int fg3a;
	private int fga;
	private int ast;
	private int dreb;
	private double fgPct;
	private int stl;
	private int fgm;
	private double ftPct;
	private double fg3Pct;
	private int pts;
	private int reb;
	private int fta;
	private int fg3m;
	private int id;
	private int turnover;
	private int ftm;

	@SerializedName("team")
	private Team team;

	@SerializedName("player")
	private Player player;

	@SerializedName("home_team")
	private HomeTeam home_team;

	@SerializedName("home_team")
	private VisitorTeam visitorTeam;


	public int getBlk(){
		return blk;
	}

	public int getFg3a(){
		return fg3a;
	}

	public int getFga(){
		return fga;
	}

	public int getAst(){
		return ast;
	}

	public int getDreb(){
		return dreb;
	}

	public double getFgPct(){
		return fgPct;
	}

	public int getStl(){
		return stl;
	}

	public int getFgm(){
		return fgm;
	}

	public double getFtPct(){
		return ftPct;
	}

	public double getFg3Pct(){
		return fg3Pct;
	}

	public int getPts(){
		return pts;
	}

	public int getReb(){
		return reb;
	}

	public int getFta(){
		return fta;
	}

	public int getFg3m(){
		return fg3m;
	}

	public int getId(){
		return id;
	}

	public int getTurnover(){
		return turnover;
	}

	public int getFtm(){
		return ftm;
	}

	public Team getTeam() {
		return team;
	}

	public Player getPlayer() {
		return player;
	}

	public HomeTeam getHome_team() {
		return home_team;
	}

	public VisitorTeam getVisitorTeam() {
		return visitorTeam;
	}

	public Statistics(int blk, int fga, int ast, int dreb, int stl, int pts, int reb, int fta, int turnover, int ftm, Team team, Player player, HomeTeam home_team, VisitorTeam visitorTeam) {
		this.blk = blk;
		this.fga = fga;
		this.ast = ast;
		this.dreb = dreb;
		this.stl = stl;
		this.pts = pts;
		this.reb = reb;
		this.fta = fta;
		this.turnover = turnover;
		this.ftm = ftm;
		this.team = team;
		this.player = player;
		this.home_team = home_team;
		this.visitorTeam = visitorTeam;
	}
}
