package com.example.newszy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.newszy.Models.NewsHeadlines;

public class DetailedNewsActivity extends AppCompatActivity {
    private WebView webView;
    NewsHeadlines newsHeadlines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_news);

        newsHeadlines=(NewsHeadlines) getIntent().getSerializableExtra("data");

        String url=newsHeadlines.getUrl();

        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
}