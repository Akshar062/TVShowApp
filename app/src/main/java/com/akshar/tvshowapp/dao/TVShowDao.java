package com.akshar.tvshowapp.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Dao;

import com.akshar.tvshowapp.models.TVShow;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import retrofit2.http.DELETE;

@Dao
public interface TVShowDao {

    @Query("SELECT * FROM tvShows")
    Flowable<List<TVShow>> getWatchlist();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable addToWatchlist(TVShow tvShow);

    @Delete
    void removeFromWatchlist(TVShow tvShow);
}
