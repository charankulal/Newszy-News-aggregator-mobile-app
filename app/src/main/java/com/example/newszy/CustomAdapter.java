package com.example.newszy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newszy.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter <CustomViewHolder> {
    private Context context;
    private  List<NewsHeadlines> headlines;
    private SelectListener listener;


    public CustomAdapter(Context context, List<NewsHeadlines> headlines, SelectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener=listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_items,parent,false));
    }



    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textTitle.setText(headlines.get(position).getTitle());
        holder.textSource.setText(headlines.get(position).getSource().getName());
        if (headlines.isEmpty() &&  !headlines.get(holder.getAdapterPosition()).getUrlToImage().isEmpty())
        {
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.imageHeadline);
        }

        holder.cardView.setOnClickListener(v -> listener.onNewsClicked(headlines.get(position)));


    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
