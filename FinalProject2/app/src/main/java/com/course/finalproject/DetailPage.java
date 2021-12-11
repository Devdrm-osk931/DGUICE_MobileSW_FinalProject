package com.course.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailPage extends AppCompatActivity {
    private ImageView det_main;
    private ImageView det_img1;
    private ImageView det_img2;
    private ImageView det_img3;
    private TextView brand;
    private TextView pname;
    private TextView price;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        Intent intent = getIntent();
        Items info = (Items) intent.getSerializableExtra("Info");

        det_main = (ImageView) findViewById(R.id.det_main);
        det_img1 = (ImageView) findViewById(R.id.det_img1);
        det_img2 = (ImageView) findViewById(R.id.det_img2);
        det_img3 = (ImageView) findViewById(R.id.det_img3);
        brand = (TextView) findViewById(R.id.det_brand);
        pname = (TextView) findViewById(R.id.det_pname);
        price = (TextView) findViewById(R.id.det_price);
        desc = (TextView) findViewById(R.id.det_desc);

        det_main.setImageResource(info.getMain_img_id());
        det_img1.setImageResource(info.getDet_img_id1());
        det_img2.setImageResource(info.getDet_img_id2());
        det_img3.setImageResource(info.getDet_img_id3());
        brand.setText(info.getBrand());
        pname.setText(info.getName());
        price.setText(info.getPrice()+"원");
        desc.setText(info.getDescription());

        brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if (info.getBrand().equals("Logitech")) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.logitech.com"));
                }
                if(info.getBrand().equals("Razer")) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.razer.com"));
                }
                if(info.getBrand().equals("Xtrfy")) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://xtrfy.com"));
                }
                if(info.getBrand().equals("Roccat")) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.roccat.com"));
                }
                if(info.getBrand().equals("Finalmouse")) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://finalmouse.com"));
                }
                if(info.getBrand().equals("Abko")) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.abko.co.kr"));
                }
                if(info.getBrand().equals("Hansung")) {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.monsterlabs.co.kr"));
                }
                startActivity(intent);
            }
        });

    }
}