package com.jhowcs.githubapp.ui.feature.repositories;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jhowcs.githubapp.R;
import com.jhowcs.githubapp.repository.network.GithubRepository;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GithubAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvRepositories);
        initList();

        GithubRepository repository = new GithubRepository();
        repository.getAllAndroidRepositories();
    }

    private void initList() {
        adapter = new GithubAdapter();
        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }
}
