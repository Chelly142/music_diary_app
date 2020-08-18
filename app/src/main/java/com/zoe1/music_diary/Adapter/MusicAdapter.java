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


public class MusicAdapter extends RecyclerView.Adapter<MusicViewHolder> {
    ArrayList<Music> Data = null;
    Context context;

    public MusicAdapter(ArrayList<Music> data, Context context) {
        this.Data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.music_item,parent,false);
        MusicViewHolder musicViewHolder = new MusicViewHolder(view);
        return musicViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        Music music = Data.get(position);
        holder.music_name_text.setText(music.title);
        holder.artist_name_text.setText(music.artist);
        holder.rank_text.setText(music.rank);
        String[] array = music.category.split(",");
        String str = "";
        for(int i=0; i<array.length;i++){
            str += ("#"+array[i]+" ");
        }
        holder.category_tag_text.setText(str);
        Glide.with(context).load(music.image_url).into(holder.music_image);
    }


    @Override
    public int getItemCount() {
        return 0;
    }
}
class MusicViewHolder extends RecyclerView.ViewHolder {
    public ImageView music_image;
    public ImageView play_image;
    public TextView music_name_text;
    public TextView artist_name_text;
    public TextView rank_text;
    public TextView category_tag_text;
    public MusicViewHolder(@NonNull View itemView) {
        super(itemView);
        music_image = itemView.findViewById(R.id.music_image);
        play_image = itemView.findViewById(R.id.play_image);
        music_name_text = itemView.findViewById(R.id.music_name_text);
        artist_name_text = itemView.findViewById(R.id.artisit_name_text);
        rank_text = itemView.findViewById(R.id.rank_text);
        category_tag_text = itemView.findViewById(R.id.category_tag_text);
    }
}