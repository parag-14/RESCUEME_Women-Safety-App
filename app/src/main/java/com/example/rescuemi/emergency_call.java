package com.example.rescuemi;
import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.rescuemi.R;

public class emergency_call extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    EditText edittext1;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_call);

        //Getting the edittext and button instance
        edittext1=(EditText)findViewById(R.id.editText1);
        button1=(Button)findViewById(R.id.button1);

        //Performing action on button click  
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent callintent = new Intent(Intent.ACTION_CALL);
                String number=edittext1.getText().toString();
                if (number.trim().isEmpty())
                {
                    Toast.makeText(emergency_call.this,"Please Enter Phone Number",Toast.LENGTH_LONG).show();
                }
                else
                {
                    callintent.setData(Uri.parse("tel:"+number));
                }
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(emergency_call.this,"Please Grant Permission",Toast.LENGTH_LONG).show();
                }
                else
                {
                    startActivity(callintent);
                }
            }
        });
    }
    private void requestPermission()
    {
        ActivityCompat.requestPermissions(emergency_call.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE);
    }
}