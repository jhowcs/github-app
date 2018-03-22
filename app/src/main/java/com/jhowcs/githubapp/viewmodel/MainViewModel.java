package com.jhowcs.githubapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.jhowcs.githubapp.model.GithubModel;
import com.jhowcs.githubapp.repository.network.GithubRepository;

public class MainViewModel extends ViewModel {

    private GithubRepository repository;

    private LiveData<GithubModel> repositoryLiveData;

    private static final String TAG = "MainViewModel";

    public MainViewModel(GithubRepository repository) {
        this.repository = repository;
    }

    public LiveData<GithubModel> getAndroidRepositories() {
        if (repositoryLiveData == null) {
            repositoryLiveData = repository.getAllAndroidRepositories();
            Log.d(TAG, "init repositoryLiveData");
        }
        Log.d(TAG, "return repositoryLiveData created previously");
        return repositoryLiveData;
    }
}
