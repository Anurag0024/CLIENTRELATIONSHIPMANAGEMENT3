package com.example.clientrelationshipmanagement;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.jar.Attributes;

public class Main7Activity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    Button _btn1, _btn2,btndata;
    EditText _ldid2, _name2, _mobno3, _email3, _comname3, _contact3, _newnote3;
    LoginHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        dbHelper = new LoginHelper(this);

        _btn1 = (Button) findViewById(R.id.btnsub3);
        _btn2 = (Button) findViewById(R.id.btnexit3);
        btndata=(Button)findViewById(R.id.btndata3);
        _ldid2 = (EditText) findViewById(R.id.ldid2);
        _name2 = (EditText) findViewById(R.id.Name2);
        _mobno3 = (EditText) findViewById(R.id.mobno3);
        _email3 = (EditText) findViewById(R.id.email3);
        _comname3 = (EditText) findViewById(R.id.comname3);
        _contact3 = (EditText) findViewById(R.id.contact3);
        _newnote3 = (EditText) findViewById(R.id.newnote3);


        _btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ldid = _ldid2.getText().toString();
                String ldname = _name2.getText().toString();
                String mob = _mobno3.getText().toString();
                String email = _email3.getText().toString();
                String company_name = _comname3.getText().toString();
                String contact = _contact3.getText().toString();
                String newnote = _newnote3.getText().toString();

                if(dbHelper.saveopportunity (ldid,ldname,mob,email,company_name,contact,newnote)==true)
                {

                    Toast.makeText(getApplicationContext(), "submit sucesssfully", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "not done...", Toast.LENGTH_LONG).show();

                }

            }
        });

        _btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Main7Activity.this,Main3Activity.class);
                startActivity(in);
            }
        });
        btndata.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           String getCompany,getldid,getldname,getldno ,getmail,getMob = "";
                                           getldid=_ldid2.getText().toString().trim();
                                           getCompany = _comname3.getText().toString().trim();
                                           getldname=_name2.getText().toString().trim();
                                           getldno=_mobno3.getText().toString().trim();
                                           getmail=_email3.getText().toString().trim();
                                           Cursor cursor = dbHelper.ViewDataBy("leads", "ldid", getldid);


                                           StringBuilder stringBuilder = new StringBuilder();
                                           while (cursor.moveToNext()) {
                                               getldname=cursor.getString(2);
                                               getMob = cursor.getString(6);
                                               getldno=cursor.getString(3);
                                               getmail=cursor.getString(4);
                                               getCompany=cursor.getString(5);

                                           }
                                           _name2.setText(getldname);
                                           _contact3.setText(getMob);
                                           _mobno3.setText(getldno);
                                           _email3.setText(getmail);
                                           _comname3.setText(getCompany);


                                       }
                                   }
        );



    }

    @Override
    public void onItemSelected(AdapterView <?> parent, View view, int position, long id) {
     String text=parent.getItemAtPosition(position).toString();
     Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT);
    }

    @Override
    public void onNothingSelected(AdapterView <?> parent) {

    }

}
