package com.android.akef.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.android.akef.UI.GamesFragment;
import com.android.akef.UI.HomeFragment;
import com.android.akef.UI.MoreFragment;
import com.android.akef.UI.StreamFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 3;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return MoreFragment.newInstance();
            case 1: // Fragment # 0 - This will show FirstFragment
                return HomeFragment.newInstance();
            case 2:
                return StreamFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0 :
                title = "More";
                break;
            case 1:
                title = "Home";
                break;
            case 2:
                title = "Streaming";
                break;

        }
        return title;
    }
}
