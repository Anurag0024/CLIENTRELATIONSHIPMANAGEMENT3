package com.example.clientrelationshipmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class company extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2,e3;
    LoginHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        dbHelper=new LoginHelper(this);

        b1=(Button)findViewById(R.id.but1);
        b2=(Button)findViewById(R.id.but2);
        e1=(EditText)findViewById(R.id.cname2);
        e2=(EditText)findViewById(R.id.ccontact2);
        e3=(EditText)findViewById(R.id.email5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String companyname=e1.getText().toString();
                String contact=e2.getText().toString();
                String email=e3.getText().toString();

                if (dbHelper.savecompany(companyname,contact,email)==true)
                {
                    Toast.makeText(getApplicationContext(), "save done....", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "save failed....", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(company.this,Main3Activity.class);
                startActivity(in);
            }
        });

    }
}
