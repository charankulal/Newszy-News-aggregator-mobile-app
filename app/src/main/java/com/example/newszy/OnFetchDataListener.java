package com.example.newszy;

import com.example.newszy.Models.NewsApiResponse;
import com.example.newszy.Models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {
    void onFetchData(List<NewsHeadlines> list, String message);
    void onError(String message);

}
