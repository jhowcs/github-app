package com.jhowcs.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.jhowcs.githubapp.repository.network.GithubRepository;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private final GithubRepository repository;

    public MainViewModelFactory(GithubRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(repository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
