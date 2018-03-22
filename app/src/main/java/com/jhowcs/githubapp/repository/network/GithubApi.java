package com.jhowcs.githubapp.repository.network;

import com.jhowcs.githubapp.model.GithubModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubApi {

    @GET("search/repositories?q=android")
    Call<GithubModel> getAllAndroidRepositories();
}
