package com.eijun.project.model;

import com.google.gson.annotations.SerializedName;

public class DataItemTeam {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;


    @SerializedName("full_name")
    private String full_name;

    @SerializedName("division")
    private String division;

    @SerializedName("city")
    private String city;

    public DataItemTeam(String id, String name, String full_name, String division, String city) {
        this.id = id;
        this.name = name ;
        this.full_name = full_name;
        this.division = division;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullname(String full_name) {
        this.full_name = full_name;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFullname() {
        return full_name;
    }

    public String getDivision() {
        return division;
    }

    public String getCity() {
        return city;
    }

//    @Override
//    public String toString() {
//        return "DataItem { " +
//                ", fullname ' " + full_name + '\'' +
//                ", division ' " + division + '\'' +
//                ", city ' " + city + '\'' +
//
//                "}";
//    }

}
