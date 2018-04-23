package com.example.lakshit.passwordprotectedapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPasswordActivity extends AppCompatActivity {
Button btn;
EditText ed;
String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_password);
        //load the password
        SharedPreferences setting=getSharedPreferences("PREFS",0);
        password=setting.getString("password","");

      btn=findViewById(R.id.button2);
      ed=findViewById(R.id.editText3);

      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String text=ed.getText().toString();
              if (text.equals(password)){
                  //enter the app
                  Intent i=new Intent(getApplicationContext(),MainActivity.class);
                  startActivity(i);
                  finish();
              }
              else{
                  Toast.makeText(EnterPasswordActivity.this, "wrong password", Toast.LENGTH_SHORT).show();
              }
          }
      });
    }
}
