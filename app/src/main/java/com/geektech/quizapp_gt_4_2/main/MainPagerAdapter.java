package com.geektech.quizapp_gt_4_2.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.geektech.quizapp_gt_4_2.settings.Settings1Fragment;

public class MainPagerAdapter extends FragmentPagerAdapter {

    public MainPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;

        switch (position) {
            case 0:
                fragment = MainFragment.newInstance();
                break;
            default:
                fragment = Settings1Fragment.newInstance();
                break;
            case 1:
                fragment = Settings1Fragment.newInstance();
            break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}


