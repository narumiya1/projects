package com.eijun.project.model.staats;

public class Player{
	private String lastName;
	private int id;
	private String position;
	private int teamId;
	private String firstName;

	public Player(String lastName, int id, String position, int teamId, String firstName) {
		this.lastName = lastName;
		this.id = id;
		this.position = position;
		this.teamId = teamId;
		this.firstName = firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public int getId(){
		return id;
	}

	public String getPosition(){
		return position;
	}

	public int getTeamId(){
		return teamId;
	}

	public String getFirstName(){
		return firstName;
	}
}
