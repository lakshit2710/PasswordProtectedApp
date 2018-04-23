package com.example.lakshit.passwordprotectedapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePasswordActivity extends AppCompatActivity {
   Button btn;
   EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);
       btn=findViewById(R.id.button);
       e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String text1=e1.getText().toString();
              String text2=e2.getText().toString();
              if (text1.equals("") || text2.equals("")){
                  // there is no password
                  Toast.makeText(CreatePasswordActivity.this, "No password entered", Toast.LENGTH_SHORT).show();
              }
              else{
                  //save the password
                  if (text1.equals(text2)){
                      SharedPreferences setting=getSharedPreferences("PREFS",0);
                      SharedPreferences.Editor editor=setting.edit();
                      editor.putString("password",text1);
                      editor.apply();

                      //enter the app
                      Intent i=new Intent(getApplicationContext(),MainActivity.class);
                      startActivity(i);
                      finish();
                  }
                  else{
                      Toast.makeText(CreatePasswordActivity.this, "password doesn't match", Toast.LENGTH_SHORT).show();
                  }
              }
          }
      });
    }
}
