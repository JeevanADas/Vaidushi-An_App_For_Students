package com.example.dsuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    @Override
    public void setContentView(View view) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityContainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

        switch (item.getItemId()){
            case R.id.notice_board_menu:
                startActivity(new Intent(this, DashboardActivity.class));
                overridePendingTransition(0,0);
                finish();
                break;

            case R.id.time_table_menu:
                startActivity(new Intent(this, TimeTableActivity.class));
                overridePendingTransition(0,0);
                finish();
                break;

            case R.id.attendance_menu:
                startActivity(new Intent(this, AttendanceActivity.class));
                overridePendingTransition(0,0);
                finish();
                break;

            case R.id.subject_resources_menu:
                startActivity(new Intent(this, SubjectResourcesActivity.class));
                overridePendingTransition(0,0);
                finish();
                break;

            case R.id.academic_calendar_menu:
                startActivity(new Intent(this, AcademicCalendarActivity.class));
                overridePendingTransition(0,0);
                finish();
                break;

            case R.id.faculty_details_menu:
                startActivity(new Intent(this, FacultyDetailsActivity.class));
                overridePendingTransition(0,0);
                finish();
                break;

            case R.id.about_us_menu:
                startActivity(new Intent(this, AboutUsActivity.class));
                overridePendingTransition(0,0);
                finish();
                break;

            case R.id.logout_menu:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
                break;
        }
        return false;
    }

    protected void allocateActivityTitle(String titleString){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(titleString);
        }
    }
}

