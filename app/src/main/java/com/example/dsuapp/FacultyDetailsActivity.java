package com.example.dsuapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import com.example.dsuapp.databinding.ActivityFacultyDetailsBinding;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;

public class FacultyDetailsActivity extends DrawerBaseActivity {

    RecyclerView recyclerView;
    ArrayList<Faculties> facultiesArrayList;
    FacultiesAdapter facultiesAdapter;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
    ActivityFacultyDetailsBinding activityFacultyDetailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFacultyDetailsBinding = ActivityFacultyDetailsBinding.inflate(getLayoutInflater());
        setContentView(activityFacultyDetailsBinding.getRoot());
        allocateActivityTitle("              Faculty Details");

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data...");
        progressDialog.show();

        recyclerView = findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        facultiesArrayList = new ArrayList<Faculties>();
        facultiesAdapter = new FacultiesAdapter(FacultyDetailsActivity.this,facultiesArrayList);

        recyclerView.setAdapter(facultiesAdapter);
        EventChangeListener();
    }

    private void EventChangeListener() {
        db.collection("Faculties").orderBy("facultyName", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if (error != null){

                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                            Log.e("Firestore error",error.getMessage());
                            return;
                        }

                        for (DocumentChange dc : value.getDocumentChanges()){
                            if (dc.getType() == DocumentChange.Type.ADDED){

                                facultiesArrayList.add(dc.getDocument().toObject(Faculties.class));

                            }
                            facultiesAdapter.notifyDataSetChanged();
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                        }
                    }
                });
    }
}