package com.example.dsuapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.dsuapp.databinding.ActivityAcademicCalendarBinding;
import com.example.dsuapp.databinding.ActivityAttendanceBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.StorageReference;

public class AttendanceActivity extends DrawerBaseActivity {

    StorageReference storageReference;
    ProgressDialog progressDialog;
    String userId;
    TextView name, usn, fafl, dbms, oodj, os, electives;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    ActivityAttendanceBinding activityAttendanceBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAttendanceBinding = ActivityAttendanceBinding.inflate(getLayoutInflater());
        setContentView(activityAttendanceBinding.getRoot());
        allocateActivityTitle("           Attendance");

        progressDialog = new ProgressDialog(AttendanceActivity.this);
        progressDialog.setMessage("Fetching Attendance...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = fAuth.getCurrentUser().getUid();

        name = findViewById(R.id.attendanceName);
        usn = findViewById(R.id.attendanceUSN);
        fafl = findViewById(R.id.faflAttendance);
        dbms = findViewById(R.id.dbmsAttendance);
        oodj = findViewById(R.id.oodjAttendance);
        os = findViewById(R.id.osAttendance);
        electives = findViewById(R.id.electivesAttendance);


        DocumentReference documentReference = fStore.collection("Users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {

                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                    Log.e("Firestore error", error.getMessage());
                    return;
                }

                if(progressDialog.isShowing())
                    progressDialog.dismiss();

                name.setText(value.getString("FullName"));
                usn.setText(value.getString("USN"));
                fafl.setText(value.getString("FAFL_Attendance"));
                dbms.setText(value.getString("DBMS_Attendance"));
                oodj.setText(value.getString("OODJ_Attendance"));
                os.setText(value.getString("OS_Attendance"));
                electives.setText(value.getString("ELECTIVE_Attendance"));
            }
        });
    }
}

