package com.jhowcs.githubapp.ui.feature.repositories;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jhowcs.githubapp.R;
import com.jhowcs.githubapp.model.GithubModel;
import com.jhowcs.githubapp.model.Item;
import com.jhowcs.githubapp.repository.network.GithubRepository;
import com.jhowcs.githubapp.viewmodel.MainViewModel;
import com.jhowcs.githubapp.viewmodel.MainViewModelFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private GithubAdapter adapter;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvRepositories);
        initList();

        MainViewModelFactory factory = new MainViewModelFactory(new GithubRepository());
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
        viewModel.getAndroidRepostitories().observe(this, new Observer<GithubModel>() {
            @Override
            public void onChanged(@Nullable GithubModel githubModel) {
                List<Item> items = githubModel.getItems();

                for (Item item : items)
                    Log.d(TAG, "onChanged: " + item.getFullName());
            }
        });
    }

    private void initList() {
        adapter = new GithubAdapter();
        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }
}
