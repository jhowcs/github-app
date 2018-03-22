package com.jhowcs.githubapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.jhowcs.githubapp.model.GithubModel;
import com.jhowcs.githubapp.repository.network.GithubRepository;

public class MainViewModel extends ViewModel {

    private GithubRepository repository;

    public MainViewModel(GithubRepository repository) {
        this.repository = repository;
    }

    public LiveData<GithubModel> getAndroidRepostitories() {
        return repository.getAllAndroidRepositories();
    }
}
