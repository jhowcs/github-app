package com.jhowcs.githubapp.ui.feature.repositories;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jhowcs.githubapp.R;
import com.jhowcs.githubapp.model.Item;

import java.util.ArrayList;
import java.util.List;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubViewHolder> {

    private List<Item> itemList = new ArrayList<>();

    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repositories, parent, true);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubViewHolder holder, int position) {
        String name = itemList.get(position).getName();
        holder.txtRepositoryName.setText(name);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class GithubViewHolder extends RecyclerView.ViewHolder {
        TextView txtRepositoryName;

        public GithubViewHolder(View itemView) {
            super(itemView);

            txtRepositoryName = itemView.findViewById(R.id.txtRepositoryName);

        }
    }
}
