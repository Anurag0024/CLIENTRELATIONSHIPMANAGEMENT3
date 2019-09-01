package com.example.clientrelationshipmanagement;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class allcompanyActivity extends AppCompatActivity {
    TextView t1;
    LoginHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcompany);

        dbHelper = new LoginHelper(this);
        t1 = (TextView) findViewById(R.id.textView15);
        Cursor cursor = dbHelper.ViewData("company");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("companyname                                           contact                                                       Email");

        while (cursor.moveToNext()) {
            stringBuilder.append("\n------------------------------------------------------------------------------------------------------------------------------------------------");

            stringBuilder.append("\n  " + cursor.getString(1) + "                                       " + cursor.getString(2) + "                           " + cursor.getString(3));

        }
        t1.setText(stringBuilder);
    }

}
