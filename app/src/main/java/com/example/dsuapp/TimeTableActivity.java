package com.example.dsuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.dsuapp.databinding.ActivityTimeTableBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class TimeTableActivity extends DrawerBaseActivity {

    ActivityTimeTableBinding activityTimeTableBinding;
    StorageReference storageReference;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTimeTableBinding = ActivityTimeTableBinding.inflate(getLayoutInflater());
        setContentView(activityTimeTableBinding.getRoot());
        allocateActivityTitle("              Time Table");

        activityTimeTableBinding.fetchTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(TimeTableActivity.this);
                progressDialog.setMessage("Fetching time table...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                String imageID = activityTimeTableBinding.timeTableEnterSection.getText().toString();

                storageReference = FirebaseStorage.getInstance().getReference("TimeTable/"+imageID+".jpg");

                try {
                    File localfile = File.createTempFile("tempfile", ".jpg");

                    storageReference.getFile(localfile)
                            .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                                    if(progressDialog.isShowing())
                                        progressDialog.dismiss();

                                    Bitmap bitmap = BitmapFactory.decodeFile(localfile.getAbsolutePath());
                                    activityTimeTableBinding.timeTableImage.setImageBitmap(bitmap);

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            if(progressDialog.isShowing())
                                progressDialog.dismiss();

                            Bitmap bitmap = BitmapFactory.decodeFile(localfile.getAbsolutePath());
                            activityTimeTableBinding.timeTableImage.setImageBitmap(null);

                            Toast.makeText(TimeTableActivity.this, "Failed to Retrieve image, Please enter a valid section", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}

