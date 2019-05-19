package com.example.mac.famousrepos.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

// class that holds result of api call, with serialization annotations for gson mapping

public class RepoList {

    @SerializedName("total_count")
    public int count;

    @SerializedName("incomplete_results")
    public boolean incomplete;

    @SerializedName("items")
    List<RepoInfo> repos = new ArrayList<>();
}
