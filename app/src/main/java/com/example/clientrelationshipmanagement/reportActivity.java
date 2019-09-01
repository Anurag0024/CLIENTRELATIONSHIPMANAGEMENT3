package com.example.clientrelationshipmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class reportActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        btn1=(Button)findViewById(R.id.b55);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(reportActivity.this,allcontactsActivity.class);
                startActivity(in);
            }
        });
        btn2=(Button)findViewById(R.id.b56);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(reportActivity.this,allleadsActivity.class);
                startActivity(in);
            }
        });
        btn3=(Button)findViewById(R.id.b57);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(reportActivity.this,allcompanyActivity.class);
                startActivity(in);
            }
        });
        btn4=(Button)findViewById(R.id.b58);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(reportActivity.this,allapportunityActivity.class);
                startActivity(in);
            }
        });
        btn5=(Button)findViewById(R.id.b59);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(reportActivity.this,Main3Activity.class);
                startActivity(in);
            }
        });

    }
}
