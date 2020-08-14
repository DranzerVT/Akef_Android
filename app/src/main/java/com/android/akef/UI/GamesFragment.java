package com.android.akef.UI;

import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.akef.R;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;

public class GamesFragment extends Fragment {

    private GamesViewModel mViewModel;
    NestedScrollView mScrollView;

    public static GamesFragment newInstance() {
        return new GamesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.games_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mScrollView = view.findViewById(R.id.scrollView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GamesViewModel.class);
        MaterialViewPagerHelper.registerScrollView(getActivity(), mScrollView);
    }

}