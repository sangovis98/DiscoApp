package com.example.discoapp;

import android.os.Bundle;

import com.example.discoapp.modelo.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NavigationActivity extends AppCompatActivity {

    public DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    private AppBarConfiguration mAppBarConfiguration;
    public ArrayList<Discoteca> discotecas = new ArrayList<Discoteca>();
    public ArrayAdapter<String> discoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onStart(){
        super.onStart();
        DatabaseReference discos = db.child("Discotecas");
        discos.orderByChild("id").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                Discoteca disco = dataSnapshot.getValue(Discoteca.class);
                discotecas.add(disco);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                /*Discoteca disco = dataSnapshot.getValue(Discoteca.class);
                discotecas.add(disco);*/
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                /*Discoteca disco = dataSnapshot.getValue(Discoteca.class);
                discotecas.add(disco);*/
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {
                /*Discoteca disco = dataSnapshot.getValue(Discoteca.class);
                discotecas.add(disco);*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ListView lista = (ListView) findViewById(R.id.ListaDiscotecas);
        ArrayList<String> listaDiscos = new ArrayList<String>();
        for(Discoteca d : discotecas)
            listaDiscos.add(d.getNombre());
        discoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaDiscos);
        lista.setAdapter(discoAdapter);
    }
}
