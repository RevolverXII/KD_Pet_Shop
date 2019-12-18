package com.felix.kdpetshop;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    private int tabCount;

    public PagerAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new dog();
            case 1:
                return new cat();
            case 2:
                return new sugarglider();
            case 3:
                return new reptile();
        }
        return null;
    }


    @Override
    public int getCount() {
        return tabCount;
    }
}
