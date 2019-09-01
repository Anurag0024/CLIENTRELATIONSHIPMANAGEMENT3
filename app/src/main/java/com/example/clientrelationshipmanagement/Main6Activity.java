package com.example.clientrelationshipmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import java.util.jar.Attributes;

public class Main6Activity extends AppCompatActivity {

    Button _btn1,_btn2,btndata;
    EditText _ldid1,_name1,_mobno2,_email2,_comname2,_contact2,_newnote2;
    LoginHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        dbHelper =new LoginHelper( this);

        _btn1=(Button)findViewById(R.id.btnsub2);
        _btn2=(Button)findViewById(R.id.btnexit2);
        btndata=(Button)findViewById(R.id.btndata2);
        _ldid1=(EditText)findViewById(R.id.ldid1);
        _name1=(EditText)findViewById(R.id.name1);
        _mobno2=(EditText)findViewById(R.id.mobno2);
        _email2=(EditText)findViewById(R.id.email2);
        _comname2=(EditText)findViewById(R.id.comname2);
        _contact2=(EditText)findViewById(R.id.contact2);
        _newnote2=(EditText)findViewById(R.id.newnote2);

        _btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ldid=_ldid1.getText().toString();
                String ldname=_name1.getText().toString();
                String mob=_mobno2.getText().toString();
                String email=_email2.getText().toString();
                String company_name=_comname2.getText().toString();
                String contact=_contact2.getText().toString();
                String newnote=_newnote2.getText().toString();

                if(dbHelper.saveLeads(ldid,ldname,mob,email,company_name,contact,newnote)==true)
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
                 Intent in=new Intent(Main6Activity.this,Main3Activity.class);
                 startActivity(in);
             }
         });
        btndata.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           String getCompany,getldname,getldno ,getmail,getMob = "";
                                           getCompany = _comname2.getText().toString().trim();
                                           getldname=_name1.getText().toString().trim();
                                           getldno=_mobno2.getText().toString().trim();
                                           getmail=_email2.getText().toString().trim();
                                           Cursor cursor = dbHelper.ViewDataBy("addcontact", "ldname", getldname);


                                           StringBuilder stringBuilder = new StringBuilder();
                                           while (cursor.moveToNext()) {
                                               getMob = cursor.getString(2);
                                               getldno=cursor.getString(2);
                                               getmail=cursor.getString(3);
                                               getCompany=cursor.getString(4);

                                           }
                                           _contact2.setText(getMob);
                                           _mobno2.setText(getldno);
                                           _email2.setText(getmail);
                                           _comname2.setText(getCompany);


                                       }
                                   }
        );
    }


}
