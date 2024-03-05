package com.akshar.tvshowapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.akshar.tvshowapp.repositories.MostPopularTVShowRepository;
import com.akshar.tvshowapp.responses.TVShowResponse;

public class MostPopularTVShowViewModel extends ViewModel {
    private MostPopularTVShowRepository mostPopularTVShowRepository;

    public MostPopularTVShowViewModel() {
        mostPopularTVShowRepository = new MostPopularTVShowRepository();
    }

    public LiveData<TVShowResponse> getMostPopularTVShows(int page) {
        return mostPopularTVShowRepository.getMostPopularTVShows(page);
    }


}
