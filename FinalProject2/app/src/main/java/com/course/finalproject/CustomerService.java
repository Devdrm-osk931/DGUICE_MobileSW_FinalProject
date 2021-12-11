package com.course.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CustomerService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service);
        Button callbutton = (Button) findViewById(R.id.call_button);
        Button emailbutton = (Button) findViewById(R.id.email_button);
        Button mapbutton = (Button) findViewById(R.id.map_button);

        callbutton.setOnClickListener(new View.OnClickListener() {
            String number = "01050669037";
            public void onClick(View v) {
                Context context = v.getContext();
                Intent callintent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                context.startActivity(callintent);
            }
        });

        emailbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent emailIntent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"osk931@daum.net"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "문의사항");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "문의 내용을 작성해주세요-!");
                try {
                    context.startActivity(Intent.createChooser(emailIntent, "문의 이메일"));
                }catch(android.content.ActivityNotFoundException ex)
                {
                    Toast.makeText(context, "No Email client found", Toast.LENGTH_LONG).show();
                }
            }
        });

        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent mapIntent = new Intent(context, MapsActivity.class);
                startActivity(mapIntent);
            }
        });
    }
}