package com.zoe1.music_diary.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.zoe1.music_diary.R;
import com.zoe1.music_diary.Adapter.TabPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        tabLayout = findViewById(R.id.tab_layout);
        int music_count = 100;
        int diary_count = 100;
        int category_count = 100;
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("곡",music_count)));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("일기",diary_count)));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("장르",category_count)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = findViewById(R.id.view_pager);
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(tabPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                TextView menu_name_text = tab.getCustomView().findViewById(R.id.tab_name_text);
                TextView count_text = tab.getCustomView().findViewById(R.id.count_text);
                Drawable d = getResources().getDrawable(R.drawable.blue_textview_round_custom);
                count_text.setBackground(d);
                menu_name_text.setTextColor(Color.parseColor("#001BFF"));
                count_text.setTextColor(Color.parseColor("#001BFF"));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                TextView menu_name_text = tab.getCustomView().findViewById(R.id.tab_name_text);
                TextView count_text = tab.getCustomView().findViewById(R.id.count_text);
                Drawable d = getResources().getDrawable(R.drawable.textview_round_custom);
                count_text.setBackground(d);
                menu_name_text.setTextColor(Color.parseColor("#FFFFFF"));
                count_text.setTextColor(Color.parseColor("#FFFFFF"));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
    private View createTabView(String tabName,Integer count) {
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);
        TextView menu_name_text =  tabView.findViewById(R.id.tab_name_text);
        TextView count_text = tabView.findViewById(R.id.count_text);
        menu_name_text.setText(tabName);
        count_text.setText(count+"");
        if (tabName =="곡"){
            Drawable d = getResources().getDrawable(R.drawable.blue_textview_round_custom);
            count_text.setBackground(d);
            menu_name_text.setTextColor(Color.parseColor("#001BFF"));
            count_text.setTextColor(Color.parseColor("#001BFF"));
        }
        return tabView;
    }
}