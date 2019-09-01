package com.example.clientrelationshipmanagement;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TestFile extends AppCompatActivity {
    LoginHelper dbhelper;
String newb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_file);
        dbhelper = new LoginHelper(this);

        Cursor cursor = dbhelper.ViewData("addcontact");
        StringBuilder stringBuilder = new StringBuilder();

        while (cursor.moveToNext()) {
            stringBuilder.append(cursor.getString(1));

            Button b= new Button(this);
            b.setText(stringBuilder);
            b.setWidth(30);

            LinearLayout ll = (LinearLayout) findViewById(R.id.rl);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ll.addView(b, lp);
        }
        int i=0;
        while(i<=3) {

            i++;
        }
       // b.setText(stringBuilder);
    }
}
