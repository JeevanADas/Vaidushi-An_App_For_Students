package com.example.dsuapp;

import androidx.annotation.NonNull;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dsuapp.databinding.ActivityAcademicCalendarBinding;
import com.example.dsuapp.databinding.ActivityTimeTableBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;


public class AcademicCalendarActivity extends DrawerBaseActivity {

    ActivityAcademicCalendarBinding activityAcademicCalendarBinding;
    StorageReference storageReference;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAcademicCalendarBinding = ActivityAcademicCalendarBinding.inflate(getLayoutInflater());
        setContentView(activityAcademicCalendarBinding.getRoot());
        allocateActivityTitle("         Academic Calendar");

        activityAcademicCalendarBinding.fetchAcademicCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(AcademicCalendarActivity.this);
                progressDialog.setMessage("Fetching Academic Calendar...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                String calendarID = activityAcademicCalendarBinding.academicCalendarEnterSection.getText().toString();

                storageReference = FirebaseStorage.getInstance().getReference("AcademicCalendar/"+calendarID+"/AC.jpg");

                try {
                    File localfile = File.createTempFile("tempfile", ".jpg");

                    storageReference.getFile(localfile)
                            .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                                    if(progressDialog.isShowing())
                                        progressDialog.dismiss();

                                    Bitmap bitmap = BitmapFactory.decodeFile(localfile.getAbsolutePath());
                                    activityAcademicCalendarBinding.academicCalendarImage.setImageBitmap(bitmap);

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            if(progressDialog.isShowing())
                                progressDialog.dismiss();

                            Bitmap bitmap = BitmapFactory.decodeFile(localfile.getAbsolutePath());
                            activityAcademicCalendarBinding.academicCalendarImage.setImageBitmap(null);

                            Toast.makeText(AcademicCalendarActivity.this, "Failed to Retrieve image, Please enter a valid section", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}

