package com.example.viewpagertest;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

public class PagerFragAdapter extends FragmentStatePagerAdapter {
    List<String> strings;
    BlankFragment blankFragment;


    public PagerFragAdapter(FragmentManager fm, List<String> strings) {
        super(fm);
        this.strings = strings;
    }

    @Override
    public Fragment getItem(int i) {
        BlankFragment blankFragment = BlankFragment.newInstance(strings.get(i));
        if (i == 0) {
            this.blankFragment = blankFragment;
        }
        return blankFragment;
    }

    @Override
    public int getCount() {
        return strings.size();
    }


    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        if (getBlankFragment() != object) {
            blankFragment = (BlankFragment) object;
        }
        super.setPrimaryItem(container, position, object);
    }

    public BlankFragment getBlankFragment() {
        return blankFragment;
    }
}
