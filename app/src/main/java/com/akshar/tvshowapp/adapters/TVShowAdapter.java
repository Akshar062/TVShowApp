package com.akshar.tvshowapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akshar.tvshowapp.databinding.ItemContainerTvShowBinding;
import com.akshar.tvshowapp.listeners.TVShowsListeners;
import com.akshar.tvshowapp.models.TVShow;

import java.util.List;

public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder> {

    private List<TVShow> tvShows;
    private LayoutInflater layoutInflater;
    private TVShowsListeners tvShowsListeners;
    public TVShowAdapter(List<TVShow> tvShows, TVShowsListeners tvShowsListeners) {
        this.tvShows = tvShows;
        this.tvShowsListeners = tvShowsListeners;
    }

    @NonNull
    @Override
    public TVShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemContainerTvShowBinding tvShowBinding = ItemContainerTvShowBinding.inflate(layoutInflater, parent, false);
        return new TVShowViewHolder(tvShowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TVShowViewHolder holder, int position) {
        holder.bindTVShow(tvShows.get(position));

    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    class TVShowViewHolder extends RecyclerView.ViewHolder {

        private ItemContainerTvShowBinding itemContainerTvShowBinding;

        public TVShowViewHolder(ItemContainerTvShowBinding itemContainerTvShowBinding) {
            super(itemContainerTvShowBinding.getRoot());
            this.itemContainerTvShowBinding = itemContainerTvShowBinding;
        }
        public void bindTVShow(TVShow tvShow) {
            itemContainerTvShowBinding.setTvShows(tvShow);
            itemContainerTvShowBinding.executePendingBindings();
            itemContainerTvShowBinding.getRoot().setOnClickListener(v -> tvShowsListeners.onTVShowClicked(tvShow));
        }
    }
}
