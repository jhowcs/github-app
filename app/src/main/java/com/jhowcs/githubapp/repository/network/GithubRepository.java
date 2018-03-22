package com.jhowcs.githubapp.repository.network;

import android.util.Log;

import com.jhowcs.githubapp.model.GithubModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubRepository {

    public void getAllAndroidRepositories() {
        GithubApi api = BaseApi.getInstance().create(GithubApi.class);
        api.getAllAndroidRepositories().enqueue(new Callback<GithubModel>() {
            @Override
            public void onResponse(Call<GithubModel> call, Response<GithubModel> response) {
            }

            @Override
            public void onFailure(Call<GithubModel> call, Throwable t) {
                Log.d("TAG", "error: " + t.getMessage());
            }
        });
    }
}
