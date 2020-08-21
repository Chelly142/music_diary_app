package com.zoe1.music_diary.Fragment.Activitiy;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zoe1.music_diary.Activity.MainActivity;
import com.zoe1.music_diary.Adapter.MusicAdapter;
import com.zoe1.music_diary.Adapter.SearchAdapter;
import com.zoe1.music_diary.Music;
import com.zoe1.music_diary.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class musicFragment extends Fragment {
    ArrayList<Music> music_data =new ArrayList<>();
    ArrayList<Music> search_data = new ArrayList<>();
    RecyclerView music_recyclerView;
    RecyclerView search_recyclerVIew;
    ImageView addImage;
    ImageView searchImage;
    EditText add_edit;
    TextView search_type;
    TextView sort_type;
    TextView modify_text;
    TextView plz_text;
    MusicAdapter musicAdapter;
    //SearchAdapter searchAdapter;
    public static musicFragment newInstance() {
        return new musicFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music,null);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        layoutManager1.setOrientation(RecyclerView.VERTICAL);
        musicAdapter = new MusicAdapter(music_data,getActivity());
        music_recyclerView =  view.findViewById(R.id.music_recycler);
        music_recyclerView.setLayoutManager(layoutManager1);
        music_recyclerView.setAdapter(musicAdapter);
        /*LinearLayoutManager layoutManager2 = new LinearLayoutManager(context);
        layoutManager2.setOrientation(RecyclerView.VERTICAL);
        search_recyclerVIew = view.findViewById(R.id.search_recycler);
        searchAdapter = new SearchAdapter(search_data,context);
        search_recyclerVIew.setLayoutManager(layoutManager2);
        search_recyclerVIew.setAdapter(searchAdapter);
        search_recyclerVIew.setVisibility(View.INVISIBLE);*/

        addImage = view.findViewById(R.id.add_image);
        searchImage = view.findViewById(R.id.search_image);
        sort_type = view.findViewById(R.id.sort_type_text);
        modify_text = view.findViewById(R.id.list_modify_text);
        add_edit = view.findViewById(R.id.add_text);
        search_type = view.findViewById(R.id.search_type_text);
        //plz_text = view.findViewById(R.id.plz_text);
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_edit.setVisibility(View.VISIBLE);
                search_type.setVisibility(View.VISIBLE);
                addImage.setVisibility(View.INVISIBLE);
                searchImage.setVisibility(View.INVISIBLE);
                sort_type.setVisibility(View.INVISIBLE);
                //modify_text.setVisibility(View.INVISIBLE);
                //plz_text.setVisibility(View.VISIBLE);
                //search_recyclerVIew.setVisibility(View.VISIBLE);

            }
        });
        /*search_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (search_type.getText()=="아티스트"){
                    search_type.setText("곡");
                    new search_Back().execute(add_edit.getText().toString());
                }
                else{
                    search_type.setText("아티스트");
                    new search_Back().execute(add_edit.getText().toString());
                }
            }
        });*/
        add_edit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    new search_Back().execute(add_edit.getText().toString());
                }
                return false;
            }
        });
        add_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s==""){
                    //search_recyclerVIew.setVisibility(View.VISIBLE);
                }
                else{
                    new search_Back().execute(add_edit.getText().toString());
                    //search_recyclerVIew.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }
    public class search_Back extends AsyncTask<String,Integer,Void>{
        @Override
        protected Void doInBackground(String... strings) {
            music_data.clear();
            try {
                Document document1 = Jsoup.connect("https://www.melon.com/search/song/index.htm?q="+strings[0]+"&section=&searchGnbYn=Y&kkoSpl=N&kkoDpType=&ipath=srch_form").get();
                Elements elements1 = document1.select("tbody").select("tr");
                int i=0;
                for(Element element1: elements1){
                    Elements tr_elements = element1.select("td");
                    String music_name = tr_elements.get(2).select("a.fc_gray").text();
                    String artist_name = tr_elements.get(3).select("a.fc_mgray").text();
                    String album_info = tr_elements.get(4).select("a").attr("href");
                    String album_id = album_info.substring(album_info.length()-11,album_info.length()-3);
                    String album_img_url = "https://cdnimg.melon.co.kr/cm2/album/images/"+album_id.substring(0,3)+"/"+album_id.substring(3,5)+"/"+album_id.substring(5,8)+"/"+album_id+".jpg";
                    Music music = new Music(music_name,artist_name,album_img_url);
                    music_data.add(i,music);
                    publishProgress(i);
                    i++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            musicAdapter.notifyItemChanged(values[0]);
            Log.e("gang","갱신 됨"+values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.e("gang",music_data+"");
            Log.e("gang",musicAdapter.getData()+"");
        }
    }

}
