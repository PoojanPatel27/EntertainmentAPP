package com.example.myapplication.newtablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText emailLog,passwordLog;
    Button login;
    TextView signup;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLog= findViewById(R.id.emailLog);
        passwordLog = findViewById(R.id.passwordLog);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signupTxt);


        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginuser();

            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void loginuser() {

        String email = emailLog.getText().toString();
        String password = passwordLog.getText().toString();

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Logging in....");
        progressDialog.show();

        if (TextUtils.isEmpty(email)){
            emailLog.setError("Email cannot be empty");
            emailLog.requestFocus();
            progressDialog.dismiss();


        }else if (TextUtils.isEmpty(password)){
            passwordLog.setError("Password Cannot be empty");
            passwordLog.requestFocus();
            progressDialog.dismiss();

        }else {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){
                        Toast.makeText(Login.this, "Logged in Successfully!!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();
                        progressDialog.dismiss();


                    }else {
                        Toast.makeText(Login.this, "Login failed!!", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();


                    }
                }
            });
        }

    }
}