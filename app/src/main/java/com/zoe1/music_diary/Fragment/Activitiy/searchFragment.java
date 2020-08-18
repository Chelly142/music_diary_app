package com.zoe1.music_diary.Fragment.Activitiy;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.zoe1.music_diary.Music;
import com.zoe1.music_diary.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Entity;

import java.io.IOException;

public class searchFragment extends Fragment {
    EditText add_text;
    TextView search_type_text;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search,null);
        add_text =  view.findViewById(R.id.add_text);
        search_type_text = view.findViewById(R.id.search_type_text);
        add_text.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    new search_Back().execute(add_text.getText().toString());
                }
                return false;
            }
        });
        search_type_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (search_type_text.getText()=="아티스트"){
                    search_type_text.setText("곡");
                    new search_Back().execute(add_text.getText().toString());
                }
                else{
                    search_type_text.setText("아티스트");
                    new search_Back().execute(add_text.getText().toString());
                }
            }
        });
        return super.onCreateView(inflater, container, savedInstanceState);

    }
    public class search_Back extends AsyncTask<String,Void,Void>{

        @Override
        protected Void doInBackground(String... strings) {
            try {
                Document document1 = Jsoup.connect("https://www.melon.com/search/song/index.htm?q="+strings[0]+"&section=artist&searchGnbYn=Y&kkoSpl=N&kkoDpType=&ipath=srch_form").get();
                Elements elements1 = document1.select("div").select("tbody");
                for(Element element1: elements1){
                    String music_name = element1.select(".wrap pd_none").select(".fc_gray").text();
                    String artist_name = element1.select(".wrap wrapArtistName").select("a").text();
                    String album_id = element1.select(".wrap").select(".fc_mgray").attr("abs:href").split("'")[1];
                    String album_img_url = "https://cdnimg.melon.co.kr/cm2/album/images/104/73/972/"+album_id+"_500.jpg?4a29438f57e13cf40eb3fefc8446109b/melon/quality/80/optimize";
                    Music music = new Music(music_name,artist_name,album_img_url);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
