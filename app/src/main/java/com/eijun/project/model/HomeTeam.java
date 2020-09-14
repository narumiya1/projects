package com.eijun.project.model;

import com.google.gson.annotations.SerializedName;

public class HomeTeam{

	@SerializedName("division")
	private String division;

	@SerializedName("conference")
	private String conference;

	@SerializedName("full_name")
	private String fullName;

	@SerializedName("city")
	private String city;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("abbreviation")
	private String abbreviation;

	public HomeTeam(String division, String conference, String fullName, String city, String name, int id, String abbreviation) {
		this.division = division;
		this.conference = conference;
		this.fullName = fullName;
		this.city = city;
		this.name = name;
		this.id = id;
		this.abbreviation = abbreviation;
	}

	public void setDivision(String division){
		this.division = division;
	}

	public String getDivision(){
		return division;
	}

	public void setConference(String conference){
		this.conference = conference;
	}

	public String getConference(){
		return conference;
	}

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return fullName;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAbbreviation(String abbreviation){
		this.abbreviation = abbreviation;
	}

	public String getAbbreviation(){
		return abbreviation;
	}
}