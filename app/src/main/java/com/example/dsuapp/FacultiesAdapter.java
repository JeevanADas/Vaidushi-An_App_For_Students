package com.example.dsuapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class FacultiesAdapter extends RecyclerView.Adapter<FacultiesAdapter.MyViewHolder>{

    Context context;
    ArrayList<Faculties> facultiesArrayList;

    public FacultiesAdapter(Context context, ArrayList<Faculties> facultiesArrayList) {
        this.context = context;
        this.facultiesArrayList = facultiesArrayList;
    }

    @NonNull
    @Override
    public FacultiesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.faculty_recycler_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FacultiesAdapter.MyViewHolder holder, int position) {
        holder.adFacultyName.setText(facultiesArrayList.get(position).getFacultyName());
        holder.adFacultyDept.setText(facultiesArrayList.get(position).getFacultyDept());
        holder.adFacultyPhoneNumber.setText(facultiesArrayList.get(position).getFacultyPhoneNumber());
        holder.adFacultyEmail.setText(facultiesArrayList.get(position).getFacultyEmail());
        holder.adFacultyCabinNumber.setText(facultiesArrayList.get(position).getFacultyCabinNumber());
    }

    @Override
    public int getItemCount() {
        return facultiesArrayList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView adFacultyName, adFacultyDept, adFacultyPhoneNumber, adFacultyEmail, adFacultyCabinNumber;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            adFacultyName = itemView.findViewById(R.id.tvFacultyName);
            adFacultyDept = itemView.findViewById(R.id.tvFacultyDept);
            adFacultyPhoneNumber = itemView.findViewById(R.id.tvFacultyPhoneNumber);
            adFacultyEmail = itemView.findViewById(R.id.tvFacultyEmail);
            adFacultyCabinNumber = itemView.findViewById(R.id.tvFacultyCabinNumber);
        }
    }
}
