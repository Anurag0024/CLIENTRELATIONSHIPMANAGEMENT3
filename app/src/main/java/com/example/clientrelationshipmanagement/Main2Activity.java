package com.example.clientrelationshipmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button _btnLog,btnreg;
    EditText _txtId,_txtPassword;
    String getUsername,getPassword;
    LoginHelper dbHelper;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        _txtId=(EditText)findViewById(R.id.txtId);
        _txtPassword=(EditText)findViewById(R.id.txtPass);
        _btnLog=(Button)findViewById(R.id.btnLogin);
         dbHelper=new LoginHelper(this);

        _btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsername=_txtId.getText().toString();
                getPassword=_txtPassword.getText().toString();
                if(getUsername.equals(null)==true || getUsername.equals("")==true || getPassword.equals(null) || getPassword.equals("")==true   )
                {
                    Toast.makeText(getApplicationContext(), "Required Feild....", Toast.LENGTH_LONG).show();
                }

               else
                {
                    if(dbHelper.chkmail(getUsername)==true && dbHelper.chkmail(getPassword)==true){
                        Intent in = new Intent(Main2Activity.this,Main3Activity.class);
                        startActivity(in);
                        Toast.makeText(getApplicationContext(),"WELCOME TO CRM.........",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "login failed......", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

             btnreg=(Button)findViewById(R.id.btnregister);
             btnreg.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent in=new Intent( Main2Activity.this,Main2registerActivity.class);
                     startActivity(in);

                 }
             });

                 }


}
