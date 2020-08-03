package com.android.akef.UI;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.akef.Adapters.TrendingGamesAdapter;
import com.android.akef.R;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    NestedScrollView mScrollView;
    RecyclerView gameListView;
    TrendingGamesAdapter trendingGamesAdapter;
    private Context mContext;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mScrollView = view.findViewById(R.id.scrollView);
        gameListView = view.findViewById(R.id.trend_games_list);
        gameListView.setLayoutManager(new GridLayoutManager(mContext,
                1, GridLayoutManager.HORIZONTAL,false));

        trendingGamesAdapter = new TrendingGamesAdapter(mContext);
        gameListView.setAdapter(trendingGamesAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
}