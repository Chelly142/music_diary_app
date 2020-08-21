package com.zoe1.music_diary.Adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zoe1.music_diary.Music;
import com.zoe1.music_diary.R;

import java.util.ArrayList;


public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {
    ArrayList<Music> Data = null;
    Context context;

    public SearchAdapter(ArrayList<Music> data, Context context) {
        this.Data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.music_item,parent,false);
        SearchViewHolder searchViewHolder = new SearchViewHolder(view);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        Music music = Data.get(position);
        holder.music_name_text.setText(music.title);
        holder.artist_name_text.setText(music.artist);
        Glide.with(context).load(music.image_url).into(holder.music_image);
    }


    @Override
    public int getItemCount() {
        return Data.size();
    }
}
class SearchViewHolder extends RecyclerView.ViewHolder {
    public ImageView music_image;
    public ImageView play_image;
    public TextView music_name_text;
    public TextView artist_name_text;
    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);
        music_image = itemView.findViewById(R.id.music_image);
        play_image = itemView.findViewById(R.id.play_image);
        music_name_text = itemView.findViewById(R.id.music_name_text);
        artist_name_text = itemView.findViewById(R.id.artisit_name_text);
    }
}