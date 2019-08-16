package com.example.abbu.quizzy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class abc extends AppCompatActivity {
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        Bundle extras= getIntent().getExtras();
        t1.setText(extras.getString("Correct",""));
        t2.setText(extras.getString("Wrong",""));
    }
}
