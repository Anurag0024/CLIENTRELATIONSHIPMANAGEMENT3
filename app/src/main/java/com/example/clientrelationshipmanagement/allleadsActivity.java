package com.example.clientrelationshipmanagement;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class allleadsActivity extends AppCompatActivity {
    TextView t1;
    LoginHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allleads);
        dbHelper=new LoginHelper(this);
        t1=(TextView)findViewById(R.id.textView16);
        Cursor cursor = dbHelper.ViewData("leads");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    Ld.id:               Name                       Mob.                     Email                      Co.name                     Contact     ");
        while (cursor.moveToNext()){
            stringBuilder.append("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            stringBuilder.append("\n  "+cursor.getString(1)+"     "+cursor.getString(2)+"    "+cursor.getString(3)+"       "+cursor.getString(4)+"         "+cursor.getString(5)+"       "+cursor.getString(6));}

        t1.setText(stringBuilder);
    }
}
