package com.example.clientrelationshipmanagement;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class allcontactsActivity extends AppCompatActivity {
    TextView t1;
    LoginHelper dbhelper;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcontacts);


        dbhelper = new LoginHelper(this);
        t1 = (TextView) findViewById(R.id.textView3);
        Cursor cursor = dbhelper.ViewData("addcontact");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ld.name            mobile                  Email                    Company                      Contact");
        while (cursor.moveToNext()) {
            stringBuilder.append("\n---------------------------------------------------------------------------------------------------------------------");
            stringBuilder.append("\n  " + cursor.getString(1) + "      " + cursor.getString(2) + "     " + cursor.getString(3) + "   " + cursor.getString(4) + "         " + cursor.getString(5));

        }
         t1.setText(stringBuilder);
        }
    }


