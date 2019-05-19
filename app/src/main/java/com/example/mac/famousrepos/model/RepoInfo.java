package com.example.mac.famousrepos.model;

import com.google.gson.annotations.SerializedName;

// class that holds repo information with serialization annotations for gson mapping

public class RepoInfo {

    @SerializedName("name")
    private String name;

    @SerializedName("login")
    private String owner;

    @SerializedName("stargazers_count")
    private String stars;

    @SerializedName("description")
    private String description;

    public RepoInfo(String name, String owner, String description, String stars) {
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getStars() {
        return stars;
    }

    public String getDescription() {
        return description;
    }
}