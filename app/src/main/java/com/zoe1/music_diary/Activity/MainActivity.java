package com.zoe1.music_diary.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.zoe1.music_diary.R;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        tabLayout = findViewById(R.id.tab_layout);
        int music_count = 0;
        int diary_count = 0;
        int category_count = 0;
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("곡",music_count)));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("일기",diary_count)));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("장르",category_count)));
    }
    private View createTabView(String tabName,Integer count) {
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);
        TextView menu_name_text =  tabView.findViewById(R.id.menu_name_text);
        TextView count_text = tabView.findViewById(R.id.count_text);
        menu_name_text.setText(tabName);
        count_text.setText("("+count+")");
        return tabView;
    }
}