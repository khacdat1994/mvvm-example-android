package com.pigapps.ringtones.mvvvmretrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubClient_ {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.github.com/";

    public static GitHubService getService() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(GitHubService.class);
    }
}
