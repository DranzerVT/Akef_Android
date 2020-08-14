package com.android.akef.UI;

import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.akef.Adapters.TrendingGamesAdapter;
import com.android.akef.R;
import com.android.akef.Utils.Variables;
import com.github.florent37.materialviewpager.MaterialViewPagerHelper;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    NestedScrollView mScrollView;
    RecyclerView gameListView;
    TrendingGamesAdapter trendingGamesAdapter;
    private Context mContext;
    Button btnAdminPanel, btnEsportsRegistration;

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
        btnAdminPanel = view.findViewById(R.id.btn_admin_panel);
        btnEsportsRegistration = view.findViewById(R.id.esports_reg_btn);

        trendingGamesAdapter = new TrendingGamesAdapter(mContext);
        gameListView.setAdapter(trendingGamesAdapter);

        btnAdminPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://docs.google.com/document/d/1hMJhNwv0wKR4DHTV3SmY_LJFDQlZvJQMFnuEDdJLj7I/edit");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnEsportsRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,WebViewActivity.class);
                intent.putExtra(Variables.WEBVIEW_URL_KEY,"https://www.akef.in/esports-organization-registration/");
                startActivity(intent);
            }
        });
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