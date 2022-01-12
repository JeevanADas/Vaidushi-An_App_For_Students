package com.example.dsuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {
    EditText fullName,email,password,phone,yearOfStudy, usn;
    Button registerBtn,goToLogin;
    CheckBox isTeacherBox, isStudentBox;
    boolean valid = true;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        fullName = findViewById(R.id.registerName);
        email = findViewById(R.id.registerEmail);
        usn = findViewById(R.id.registerUsn);
        password = findViewById(R.id.registerPassword);
        phone = findViewById(R.id.registerPhone);
        registerBtn = findViewById(R.id.registerBtn);
        goToLogin = findViewById(R.id.gotoLogin);
        yearOfStudy = findViewById(R.id.registerYear);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkField(fullName);
                checkField(email);
                checkField(password);
                checkField(phone);
                checkField(usn);
                checkField(yearOfStudy);

                if(valid) {
                    // start the user registration process
                    fAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            FirebaseUser user = fAuth.getCurrentUser();
                            Toast.makeText(RegisterActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                            DocumentReference df = fStore.collection("Users").document(user.getUid());
                            Map<String, Object> userInfo = new HashMap<>();
                            userInfo.put("FullName",fullName.getText().toString());
                            userInfo.put("UserEmail",email.getText().toString());
                            userInfo.put("PhoneNumber",phone.getText().toString());
                            userInfo.put("USN",usn.getText().toString());
                            userInfo.put("Year",yearOfStudy.getText().toString());
                            if(yearOfStudy.getText().toString().equals("1"))
                            {
                                userInfo.put("PHY_Attendance", "tbd");
                                userInfo.put("CHEM_Attendance", "tbd");
                                userInfo.put("EGD_Attendance", "tbd");
                                userInfo.put("EE_Attendance", "tbd");
                                userInfo.put("EC_Attendance", "tbd");
                            }
                            if(yearOfStudy.getText().toString().equals("2"))
                            {
                                userInfo.put("DELD_Attendance", "tbd");
                                userInfo.put("DSA_Attendance", "tbd");
                                userInfo.put("DAA_Attendance", "tbd");
                                userInfo.put("PYTHON_Attendance", "tbd");
                                userInfo.put("M3_Attendance", "tbd");
                            }
                            if(yearOfStudy.getText().toString().equals("3"))
                            {
                                userInfo.put("FAFL_Attendance", "tbd");
                                userInfo.put("ELECTIVE_Attendance", "tbd");
                                userInfo.put("DBMS_Attendance", "tbd");
                                userInfo.put("OODJ_Attendance", "tbd");
                                userInfo.put("OS_Attendance", "tbd");
                            }
                            if(yearOfStudy.getText().toString().equals("4"))
                            {
                                userInfo.put("CDSS_Attendance", "tbd");
                                userInfo.put("SEPM_Attendance", "tbd");
                                userInfo.put("CYBERLAW_Attendance", "tbd");
                                userInfo.put("PE1_Attendance","tbd");
                                userInfo.put("PE2_Attendance", "tbd");
                            }
                            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                            finish();
                            df.set(userInfo);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(RegisterActivity.this, "Failed to create Account", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

    }


    public boolean checkField(EditText textField){
        if(textField.getText().toString().isEmpty()){
            textField.setError("Error");
            valid = false;
        }else {
            valid = true;
        }

        return valid;
    }
}


