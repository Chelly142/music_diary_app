package com.zoe1.music_diary.Fragment.Activitiy;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zoe1.music_diary.Adapter.MusicAdapter;
import com.zoe1.music_diary.Music;
import com.zoe1.music_diary.R;

import java.util.ArrayList;

public class musicFragment extends Fragment {
    Context context =getContext();
    ArrayList<Music> music_data = null;
    RecyclerView recyclerView;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music,null);
        recyclerView = view.findViewById(R.id.music_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        MusicAdapter musicAdapter = new MusicAdapter(music_data,context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(musicAdapter);
        return view;
    }
}
class addMusicBack extends AsyncTask{
    @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }
}

