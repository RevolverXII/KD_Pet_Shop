package com.felix.kdpetshop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView usernameTxt, passwordTxt;
    Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameTxt = findViewById(R.id.usernameTxt);
        passwordTxt = findViewById(R.id.passwordTxt);
        submitBtn = findViewById(R.id.submitBtn);
        ((View) submitBtn).setOnClickListener(new View.OnClickListener(){
            int errorvalue = 0;
            @Override
            public void onClick(View view) {
                String username = usernameTxt.getText().toString();
                String password = passwordTxt.getText().toString();
                if(username.equals("")){
                    usernameTxt.setError("Username is empty!");
                    errorvalue++;
                }else if (username.length()<6){
                    usernameTxt.setError("Username must be more than 6 char!");
                    errorvalue++;
                }
                if(password.equals("")){
                    passwordTxt.setError("Password is empty!");
                    errorvalue++;
                }else if (password.length()<6){
                    passwordTxt.setError("Password must be more than 6 char!");
                    errorvalue++;
                }
                if (errorvalue == 0){
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    SharedPreferences sp = getSharedPreferences("SP", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString( "username", username);
                    editor.commit();
                    startActivity(i);
                }
                errorvalue = 0;
            }
        });
    }
}
