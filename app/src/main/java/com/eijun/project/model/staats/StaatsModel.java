package com.eijun.project.model.staats;

public class StaatsModel{
	private String blk;
	private String fg3a;
	private String fga;
	private String ast;
	private String dreb;
	private String fgPct;
	private String stl;
	private String fgm;

	private String ftPct;
	private String fg3Pct;
	private String pts;
	private String reb;
	private String fta;
	private String fg3m;
	private String id;
	private String turnover;
	private String ftm;
	private Game game;
	private Team team;
	private Player player;


	public void setBlk(String blk) {
		this.blk = blk;
	}

	public void setFg3a(String fg3a) {
		this.fg3a = fg3a;
	}

	public void setFga(String fga) {
		this.fga = fga;
	}

	public void setAst(String ast) {
		this.ast = ast;
	}

	public void setDreb(String dreb) {
		this.dreb = dreb;
	}

	public void setFgPct(String fgPct) {
		this.fgPct = fgPct;
	}

	public void setStl(String stl) {
		this.stl = stl;
	}

	public void setFgm(String fgm) {
		this.fgm = fgm;
	}

	public void setFtPct(String ftPct) {
		this.ftPct = ftPct;
	}

	public void setFg3Pct(String fg3Pct) {
		this.fg3Pct = fg3Pct;
	}

	public void setPts(String pts) {
		this.pts = pts;
	}

	public void setReb(String reb) {
		this.reb = reb;
	}

	public void setFta(String fta) {
		this.fta = fta;
	}

	public void setFg3m(String fg3m) {
		this.fg3m = fg3m;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}

	public void setFtm(String ftm) {
		this.ftm = ftm;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getBlk(){
		return blk;
	}

	public String getFg3a(){
		return fg3a;
	}

	public String getFga(){
		return fga;
	}

	public String getAst(){
		return ast;
	}

	public String getDreb(){
		return dreb;
	}

	public String getFgPct(){
		return fgPct;
	}

	public String getStl(){
		return stl;
	}

	public String getFgm(){
		return fgm;
	}

	public String getFtPct(){
		return ftPct;
	}

	public String getFg3Pct(){
		return fg3Pct;
	}

	public String getPts(){
		return pts;
	}

	public String getReb(){
		return reb;
	}

	public String getFta(){
		return fta;
	}

	public String getFg3m(){
		return fg3m;
	}

	public String getId(){
		return id;
	}

	public String getTurnover(){
		return turnover;
	}

	public String getFtm(){
		return ftm;
	}

	public Game getGame(){
		return game;
	}

	public Team getTeam(){
		return team;
	}

	public Player getPlayer(){
		return player;
	}

	public StaatsModel(String blk, String fg3a, String fga, String ast, String dreb, String fgPct, String stl, String fgm, String ftPct, String fg3Pct, String pts, String reb, String fta, String fg3m, String id, String turnover, String ftm, Game game, Team team, Player player) {
		this.blk = blk;
		this.fg3a = fg3a;
		this.fga = fga;
		this.ast = ast;
		this.dreb = dreb;
		this.fgPct = fgPct;
		this.stl = stl;
		this.fgm = fgm;
		this.ftPct = ftPct;
		this.fg3Pct = fg3Pct;
		this.pts = pts;
		this.reb = reb;
		this.fta = fta;
		this.fg3m = fg3m;
		this.id = id;
		this.turnover = turnover;
		this.ftm = ftm;
		this.game = game;
		this.team = team;
		this.player = player;
	}
}
