package com.jhowcs.githubapp.repository.network;

import android.support.annotation.VisibleForTesting;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseApi {
    private static final String BASE_URL = "http://api.github.com/";

    private static Retrofit INSTANCE;

    private BaseApi() {}

    public static Retrofit getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return INSTANCE;
    }

    @VisibleForTesting
    public void switchRetrofitInstanceForTest(Retrofit retrofit) {
        INSTANCE = retrofit;
    }
}
