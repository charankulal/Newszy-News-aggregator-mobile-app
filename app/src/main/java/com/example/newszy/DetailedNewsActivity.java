package com.example.newszy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newszy.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class DetailedNewsActivity extends AppCompatActivity {
    NewsHeadlines headlines;
    TextView txt_title, txt_author,txt_view,txt_detail,txt_content,txt_time;
    ImageView img_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_news);

        txt_title=findViewById(R.id.text_detail_title);
        txt_author=findViewById(R.id.text_detail_author);
        txt_time=findViewById(R.id.text_detail_time);
        txt_detail=findViewById(R.id.text_detail_detail);
        txt_content=findViewById(R.id.text_detail_content);
        img_news=findViewById(R.id.image_detail_news);

        headlines= (NewsHeadlines) getIntent().getSerializableExtra("data");

        txt_title.setText(headlines.getTitle());
        txt_author.setText(headlines.getAuthor());
        txt_time.setText(headlines.getPublishedAt());
        txt_detail.setText(headlines.getDescription());
        txt_content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);
    }
}