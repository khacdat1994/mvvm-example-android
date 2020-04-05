package com.pigapps.ringtones.mvvvmretrofit.api;

import androidx.lifecycle.MutableLiveData;

import com.pigapps.ringtones.mvvvmretrofit.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitHubRepository {
    private static final String TAG = "GitHubRepository";

    public GitHubRepository() {

    }

    public MutableLiveData<List<User>> getListUsers(String name) {
        final MutableLiveData<List<User>> mutableLiveData = new MutableLiveData<>();

        GitHubClient.getService().listRepos(name).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
