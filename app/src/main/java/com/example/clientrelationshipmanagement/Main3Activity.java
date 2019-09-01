package com.example.clientrelationshipmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Main3Activity extends AppCompatActivity {
    Button btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn4=(Button)findViewById(R.id.b4);
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View V){
                Intent in=new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(in);
            }
        });
        btn5=(Button)findViewById(R.id.b5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Main3Activity.this,Main5Activity.class);
                startActivity(in);

            }
        });
        btn6=(Button)findViewById(R.id.b6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent( Main3Activity.this,Main6Activity.class);
                startActivity(in);

            }
        });
        btn7=(Button)findViewById(R.id.b7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Main3Activity.this,Main7Activity.class);
                startActivity(in);
            }
        });
        btn8=(Button)findViewById(R.id.b8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Main3Activity.this,Main8Activity.class);
                startActivity(in);
            }
        });
        btn9=(Button)findViewById(R.id.b9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Main3Activity.this,Main2Activity.class);
                startActivity(in);
            }
        });
        btn10=(Button)findViewById(R.id.b88);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(Main3Activity.this,reportActivity.class);
                startActivity(in);
            }
        });


         btn11=(Button)findViewById(R.id.b89);
         btn11.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent in =new Intent(Main3Activity.this,company.class);
                 startActivity(in);
             }
         });
    }

}


