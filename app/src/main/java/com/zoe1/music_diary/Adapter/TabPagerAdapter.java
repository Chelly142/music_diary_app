package com.zoe1.music_diary.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.zoe1.music_diary.Fragment.Activitiy.categoryFragment;
import com.zoe1.music_diary.Fragment.Activitiy.diaryFragment;
import com.zoe1.music_diary.Fragment.Activitiy.musicFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {
    private  int tabCount;
    public TabPagerAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm, tabCount);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                musicFragment musicFragment = new musicFragment();
                return  musicFragment;
            case 1:
                diaryFragment diaryFragment = new diaryFragment();
                return diaryFragment;
            case 2:
                categoryFragment categoryFragment = new categoryFragment();
                return categoryFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
