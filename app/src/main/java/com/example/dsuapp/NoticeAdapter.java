package com.example.dsuapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.MyViewHolder>{

    Context context;
    ArrayList<Notices> noticesArrayList;

    public NoticeAdapter(Context context, ArrayList<Notices> noticesArrayList) {
        this.context = context;
        this.noticesArrayList = noticesArrayList;
    }

    @NonNull
    @Override
    public NoticeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.notice_recycler_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeAdapter.MyViewHolder holder, int position) {
        holder.adNoticeSubject.setText(noticesArrayList.get(position).getNoticeSubject());
        holder.adNoticeBody.setText(noticesArrayList.get(position).getNoticeBody());
        holder.adNoticeDate.setText(noticesArrayList.get(position).getNoticeDate());
    }

    @Override
    public int getItemCount() {
        return noticesArrayList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView adNoticeSubject, adNoticeBody, adNoticeDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            adNoticeSubject = itemView.findViewById(R.id.tvNoticeHeading);
            adNoticeBody = itemView.findViewById(R.id.tvNoticeBody);
            adNoticeDate = itemView.findViewById(R.id.tvNoticeDate);
        }
    }
}
