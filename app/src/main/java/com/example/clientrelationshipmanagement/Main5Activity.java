package com.example.clientrelationshipmanagement;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    Button _btnsub, _btnexit,btndata;
    EditText _ldname1, _mobno1, _email1, _comname1, _contact, _note1;
    LoginHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        dbHelper = new LoginHelper(this);

        _btnsub = (Button) findViewById(R.id.btnsub);
        _btnexit = (Button) findViewById(R.id.btnexit);
        btndata=(Button)findViewById(R.id.btndata);
        _ldname1 = (EditText) findViewById(R.id.ldname1);
        _mobno1 = (EditText) findViewById(R.id.mobno1);
        _email1 = (EditText) findViewById(R.id.email1);
        _comname1 = (EditText) findViewById(R.id.comname1);
        _contact = (EditText) findViewById(R.id.contact1);
        _note1 = (EditText) findViewById(R.id.note1);

        _btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ldname = _ldname1.getText().toString();
                String mob = _mobno1.getText().toString();
                String email = _email1.getText().toString();
                String company_name = _comname1.getText().toString();
                String contact = _contact.getText().toString();
                String note = _note1.getText().toString();

                if (dbHelper.saveContact(ldname, mob, email, company_name, contact, note) == true) {
                    Toast.makeText(getApplicationContext(), "save done....", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "save failed....", Toast.LENGTH_LONG).show();
                }


            }
        });
        btndata.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            String getCompany, getMob = "";
                                            getCompany = _comname1.getText().toString().trim();
                                            Cursor cursor = dbHelper.ViewDataBy("company", "companyname", getCompany);
                                            StringBuilder stringBuilder = new StringBuilder();
                                            while (cursor.moveToNext()) {
                                                getMob = cursor.getString(2);
                                            }
                                            _contact.setText(getMob);
                                        }
                                    }
        );

        _btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Main5Activity.this,Main3Activity.class);
                startActivity(in);
            }
        });
    }

}

