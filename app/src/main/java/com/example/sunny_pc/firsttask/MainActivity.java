package com.example.sunny_pc.firsttask;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1,editText2;
    Button button;
    String s1,s2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=editText1.getText().toString().trim();
                String pass=editText2.getText().toString().trim();
                if(user.equals(s1)&&pass.equals(s2))
                {

                    Intent intenta=new Intent(MainActivity.this, secondactivity.class);
                    startActivity(intenta);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.sunny_pc.firsttask",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("email","sunny.kumar_mca18@gla.ac.in");
        editor.putString("password","12345");
        editor.putBoolean("bool",true);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences=getSharedPreferences("com.example.sunny_pc.firsttask",MODE_PRIVATE);
        String s1=sharedPreferences.getString("email","email");
        String s2=sharedPreferences.getString("password","password");
        Boolean remember=sharedPreferences.getBoolean("bool",false);
        Toast.makeText(this, "bool"+remember, Toast.LENGTH_SHORT).show();
        editText2.setText(s2);
        editText1.setText(s1);
    }
}
