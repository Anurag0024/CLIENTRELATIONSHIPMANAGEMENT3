package com.example.clientrelationshipmanagement;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2registerActivity extends AppCompatActivity{
    SQLiteOpenHelper loginHelper;
    SQLiteDatabase db;
    Button _btnsave;
    EditText _email,_password,_repassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2register);

        final LoginHelper dbHelper=new LoginHelper(this);

        _btnsave=(Button)findViewById(R.id.btnsave);
        _email=(EditText)findViewById(R.id.email);
        _password=(EditText)findViewById(R.id.password);
        _repassword=(EditText)findViewById(R.id.repassword);

        _btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=_email.getText().toString();
                String password=_password.getText().toString();
                String repassword=_repassword.getText().toString();

                if(email.equals(null)==true || password.equals(null)==true || repassword.equals("") || email.equals("")==true || password.equals("")==true || repassword.equals("")  )
                {
                    Toast.makeText(getApplicationContext(), "Required Feild....", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(password.equals(repassword)!=true)
                    {
                        Toast.makeText(getApplicationContext()," Password Not Matched...",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        if(dbHelper.saveData(email,password,repassword)==true)
                        {
                            Toast.makeText(getApplicationContext(),"register done....",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "register failed....", Toast.LENGTH_LONG).show();
                        }
                    }

                }

            }
        });

         }
}
