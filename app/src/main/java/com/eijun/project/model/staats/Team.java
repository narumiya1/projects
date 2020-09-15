package com.eijun.project.model.staats;

public class Team{
	private String division;
	private String conference;
	private String fullName;
	private String city;
	private String name;
	private int id;
	private String abbreviation;

	public String getDivision(){
		return division;
	}

	public String getConference(){
		return conference;
	}

	public String getFullName(){
		return fullName;
	}

	public String getCity(){
		return city;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getAbbreviation(){
		return abbreviation;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public Team(String division, String conference, String fullName, String city, String name, int id, String abbreviation) {
		this.division = division;
		this.conference = conference;
		this.fullName = fullName;
		this.city = city;
		this.name = name;
		this.id = id;
		this.abbreviation = abbreviation;
	}
}
