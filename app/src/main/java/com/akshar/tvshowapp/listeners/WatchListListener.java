package com.akshar.tvshowapp.listeners;

import com.akshar.tvshowapp.models.TVShow;

public interface WatchListListener {

    void onTVShowClicked(TVShow tvShow);

    void removeTVShowFromWatchlist(TVShow tvShow, int position);
}
