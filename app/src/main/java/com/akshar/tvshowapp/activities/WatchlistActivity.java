package com.akshar.tvshowapp.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.akshar.tvshowapp.R;
import com.akshar.tvshowapp.adapters.WatchlListAdapter;
import com.akshar.tvshowapp.databinding.ActivityWatchlistBinding;
import com.akshar.tvshowapp.listeners.WatchListListener;
import com.akshar.tvshowapp.models.TVShow;
import com.akshar.tvshowapp.viewmodels.WatchListViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class WatchlistActivity extends AppCompatActivity implements WatchListListener {

    private ActivityWatchlistBinding watchlistBinding;
    private WatchListViewModel viewModel;
    private WatchlListAdapter watchlListAdapter;
    private List<TVShow> watchList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        watchlistBinding = DataBindingUtil.setContentView(this, R.layout.activity_watchlist);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        doInitialization();
    }

    private void doInitialization() {
        viewModel = new ViewModelProvider(this).get(WatchListViewModel.class);
        watchlistBinding.imageBack.setOnClickListener(v -> onBackPressed());
        watchList = new ArrayList<>();
        loadWatchList();

    }

    private void loadWatchList() {
        watchlistBinding.setIsLoading(true);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(viewModel.loadWatchList().subscribeOn(io.reactivex.schedulers.Schedulers.io()).observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread()).subscribe(tvShows -> {
            watchlistBinding.setIsLoading(false);
            if (!watchList.isEmpty()) {
                watchList.clear();
            }
            watchList.addAll(tvShows);
            watchlListAdapter = new WatchlListAdapter(watchList, this);
            watchlistBinding.watchlistRecycleView.setAdapter(watchlListAdapter);
            watchlistBinding.watchlistRecycleView.setVisibility(android.view.View.VISIBLE);
            compositeDisposable.dispose();
        }));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (com.akshar.tvshowapp.utilities.TempDataHolder.IS_WATCHLIST_UPDATED){
            loadWatchList();
            com.akshar.tvshowapp.utilities.TempDataHolder.IS_WATCHLIST_UPDATED = false;
        }
    }

    @Override
    public void onTVShowClicked(TVShow tvShow) {
        Intent intent = new Intent(getApplicationContext(), TVShowDetailsActivity.class);
        intent.putExtra("tvShow", tvShow);
        startActivity(intent);
    }

    @Override
    public void removeTVShowFromWatchlist(TVShow tvShow, int position) {

        CompositeDisposable compositeDisposableForDelete = new CompositeDisposable();
        compositeDisposableForDelete.add(viewModel.removeTVShowFromWatchlist(tvShow).subscribeOn(io.reactivex.schedulers.Schedulers.computation()).observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread()).subscribe(() -> {
            watchList.remove(position);
            watchlListAdapter.notifyItemRemoved(position);
            watchlListAdapter.notifyItemRangeChanged(position, watchlListAdapter.getItemCount());
            compositeDisposableForDelete.dispose();
        }));
    }
}