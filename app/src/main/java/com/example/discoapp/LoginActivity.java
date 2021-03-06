package com.example.discoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.discoapp.modelo.Discoteca;
import com.example.discoapp.modelo.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private ArrayList<Usuario> usuarios;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference uidRef = mDatabase.child("usuarios");

        uidRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usuarios = new ArrayList<Usuario>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    usuarios.add(ds.getValue(Usuario.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

        Button b = findViewById(R.id.btnLogin);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = ((EditText)findViewById(R.id.correo)).getText().toString();
                String pass = ((EditText)findViewById(R.id.password)).getText().toString();
                for(Usuario u : usuarios){
                    if(u.getCorreo().equals(correo) && u.getPass().equals(pass)){
                        Intent intent = new Intent(v.getContext(), NavigationActivity.class);
                        intent.putExtra("user", u);
                        startActivity(intent);
                    }
                }
            }
        });

        Button breg = findViewById(R.id.btnReg);
        breg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewAccountActivity.class);
                intent.putExtra("id", usuarios.size()+1);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
    //No volver hacia el Splahs

    }


}
