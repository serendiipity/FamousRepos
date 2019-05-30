package com.example.mac.famousrepos.view;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mac.famousrepos.R;
import com.example.mac.famousrepos.controller.RepoListAdapter;

public class RepoViewHolder extends RecyclerView.ViewHolder {

    private CardView repoCardView;
    private TextView nameView;
    private TextView ownerView;
    private TextView descriptionView;
    private TextView starsView;
    private ImageView icon;
    private final RepoListAdapter adapter;

    public RepoViewHolder(View itemView, RepoListAdapter adapter) {

        super(itemView);
        this.adapter = adapter;
        this.repoCardView = itemView.findViewById(R.id.repo_card_view);
        this.nameView = itemView.findViewById(R.id.name);
        this.ownerView = itemView.findViewById(R.id.owner);
        this.descriptionView = itemView.findViewById(R.id.description);
        this.starsView = itemView.findViewById(R.id.stars);
        this.icon = itemView.findViewById(R.id.icon);
    }

    public CardView getRepoCardView() {
        return repoCardView;
    }

    public void setRepoCardView(CardView repoCardView) {
        this.repoCardView = repoCardView;
    }

    public TextView getNameView() {
        return nameView;
    }

    public void setNameView(TextView nameView) {
        this.nameView = nameView;
    }

    public TextView getOwnerView() {
        return ownerView;
    }

    public void setOwnerView(TextView ownerView) {
        this.ownerView = ownerView;
    }

    public TextView getDescriptionView() {
        return descriptionView;
    }

    public void setDescriptionView(TextView descriptionView) {
        this.descriptionView = descriptionView;
    }

    public TextView getStarsView() {
        return starsView;
    }

    public void setStarsView(TextView starsView) {
        this.starsView = starsView;
    }

    public ImageView getIcon() {
        return icon;
    }

    public void setIcon(ImageView icon) {
        this.icon = icon;
    }

    public RepoListAdapter getAdapter() {
        return adapter;
    }

}
