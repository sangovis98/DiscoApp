package com.example.discoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.discoapp.modelo.*;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DiscoActivity extends AppCompatActivity {

    public DatabaseReference mDatabase;
    public Discoteca d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disco);
        d = (Discoteca) getIntent().getSerializableExtra("disco");


        TextView t1 = findViewById(R.id.textView3);
        t1.setText(d.getNombre());
        TextView t2 = findViewById(R.id.textView4);
        t2.setText("Rating: "+d.getRate());

        ImageView imgD = findViewById(R.id.imageDisco);
        imgD.setImageResource(this.getResources().getIdentifier(d.getImgRuta(),"drawable", "com.example.discoapp"));

        RatingBar rb = findViewById(R.id.ratingBar);
        rb.setRating((float)d.getRate());


        //imgFoto.setImageResource(convertView.getResources().getIdentifier(Item.getImgRuta(),"drawable", "com.example.discoapp"));

        Button btnMaps = findViewById(R.id.btnMaps);
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MapsActivityCurrentPlace.class);
                intent.putExtra("disco", d);
                startActivity(intent);
            }
        });



    }
}
