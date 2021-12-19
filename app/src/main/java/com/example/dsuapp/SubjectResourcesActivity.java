package com.example.dsuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dsuapp.databinding.ActivityAttendanceBinding;
import com.example.dsuapp.databinding.ActivitySubjectResourcesBinding;

public class SubjectResourcesActivity extends DrawerBaseActivity implements View.OnClickListener {

    public CardView oodjCard, cyberSecurityCard;

    ActivitySubjectResourcesBinding activitySubjectResourcesBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySubjectResourcesBinding = ActivitySubjectResourcesBinding.inflate(getLayoutInflater());
        setContentView(activitySubjectResourcesBinding.getRoot());
        allocateActivityTitle("           Subject Resources");

        oodjCard = findViewById(R.id.cardOODJ);
        cyberSecurityCard = findViewById(R.id.cardCyberSecurity);

        oodjCard.setOnClickListener(this);
        cyberSecurityCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
    Intent intent;

    switch(view.getId()){
        case R.id.cardOODJ:
            intent = new Intent(this, SubjectResourceOodjActivity.class);
            startActivity(intent);
            break;
//        case R.id.cardCyberSecurity:
//            intent = new Intent(this, SubjectResourceCyberSecutityActivity.class);
//            startActivity(intent);
//            break;
    }
    }
}