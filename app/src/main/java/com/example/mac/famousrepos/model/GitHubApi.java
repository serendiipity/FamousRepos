package com.example.mac.famousrepos.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// api interface that is instantiated by Retrofit

public interface GitHubApi {

    // endpoint that gets appended to base url
    String url = "/search/repositories";

    // http request uses a GET method
    @GET(url)

    // query parameters for api request
    Call <RepoList> getRepos(@Query("q") String date, @Query("sort") String sort, @Query("order") String order, @Query("page") String page);
}
