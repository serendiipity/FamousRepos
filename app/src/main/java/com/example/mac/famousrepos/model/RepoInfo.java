package com.example.mac.famousrepos.model;

import com.google.gson.annotations.SerializedName;

// repo model class with annotations for gson mapping

public class RepoInfo {

    @SerializedName("name")
    private String name;

    @SerializedName("owner")
    private Owner owner;

    @SerializedName("stargazers_count")
    private String stars;

    @SerializedName("description")
    private String description;

    public RepoInfo(String name, Owner owner, String description, String stars) {
        this.name = name;
        this.owner = owner;
        this.description = description;
        this.stars = stars;
    }

    public class Owner {

        @SerializedName("login")
        private String login;

        public Owner(String login) {
            this.login = login;
        }

        public String getLogin() {
            return login;
        }
    }

    public String getName() {
        return name;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getStars() {
        return stars;
    }

    public String getDescription() {
        return description;
    }


}