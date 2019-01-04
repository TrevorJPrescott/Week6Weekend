package com.trevorpc.myapplication.views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.trevorpc.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    private Button loginButton;
    private Button newUserButton;
    private EditText etPassword;
    private EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        loginButton = findViewById(R.id.btnLogin);
        newUserButton = findViewById(R.id.btnNewUser);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password =etPassword.getText().toString();
                ValidInput(email,password);
                AuthenticateUser(auth,email,password);
            }});

        newUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password =etPassword.getText().toString();
                ValidInput(email,password);
                CreateUser(auth,email,password);

            }});
    }


    private void AuthenticateUser(FirebaseAuth auth, String email, String password){
        auth.signInWithEmailAndPassword(email,password).
                addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                        }
                        else {
                            Intent intent = new Intent(MainActivity.this, DataActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }

    private void CreateUser(FirebaseAuth auth, String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).
                addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(MainActivity.this, DataActivity.class));
                            finish();
                        }
                    }
                });
    }

    public void ValidInput(String email,String password) {
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
        }

        if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
        }

    }
}
