package com.example.mac.famousrepos.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mac.famousrepos.R;
import com.example.mac.famousrepos.model.RepoInfo;
import com.example.mac.famousrepos.model.RepoList;
import com.example.mac.famousrepos.view.RepoViewHolder;


public class RepoListAdapter extends RecyclerView.Adapter <RepoViewHolder> {

    private final RepoList repoList;
    private LayoutInflater inflater;

    public RepoListAdapter(Context context, RepoList repoList) {
        inflater = LayoutInflater.from(context);
        this.repoList = repoList;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = inflater.from(viewGroup.getContext()).inflate(R.layout.list_repo_item, viewGroup, false);
        return new RepoViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder reposViewHolder, int position) {
        RepoInfo current = repoList.getRepoList().get(position);
        reposViewHolder.getNameView().setText(current.getName());
        reposViewHolder.getOwnerView().setText(current.getOwner().getLogin());
        reposViewHolder.getDescriptionView().setText(current.getDescription());
        reposViewHolder.getStarsView().setText(current.getStars());
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return repoList.getRepoList().size();
    }

}
