package com.example.clientrelationshipmanagement;

import android.Manifest;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main8Activity extends AppCompatActivity {
    private static final int REQUEST_CALL =1 ;
    Button _btncall, b2,b3;
    EditText mEditTextNumber,comname;
    LoginHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        dbHelper = new LoginHelper(this);
        mEditTextNumber = findViewById(R.id.contact4);
        comname = findViewById(R.id.comname4);
        Button _btncall = findViewById(R.id.btncall);
        b3 = findViewById(R.id.btnsercom);

        _btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getCompany,getMob="";
                getCompany=comname.getText().toString().trim();
                Cursor cursor = dbHelper.ViewDataBy("company","companyname",getCompany);
                StringBuilder stringBuilder = new StringBuilder();
                while (cursor.moveToNext()) {
                    getMob=cursor.getString(2);
                }
                mEditTextNumber.setText(getMob);
            }
        });
    }

    private void makePhoneCall() {
        String number = mEditTextNumber.getText().toString();
        if (number.trim().length() > 0) {

            if (ContextCompat.checkSelfPermission(Main8Activity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Main8Activity.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));

            }
        } else {
            Toast.makeText(Main8Activity.this, "enter phone no.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String[]permissions,int[]grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }


}


















   






