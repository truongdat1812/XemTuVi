package com.giangdm.tuvi.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.giangdm.tuvi.fragments.ManFragment;
import com.giangdm.tuvi.fragments.WomanFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ManFragment();
                break;
            case 1:
                fragment = new WomanFragment();
                break;
            default:
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
