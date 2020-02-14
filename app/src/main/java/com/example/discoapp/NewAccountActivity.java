package com.example.discoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.discoapp.modelo.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NewAccountActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        id = getIntent().getIntExtra("id",0);
        Button b = findViewById(R.id.crearCuenta);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomb = ((EditText)findViewById(R.id.nombreUsuario)).getText().toString();
                String correo = ((EditText)findViewById(R.id.correoReg)).getText().toString();
                String pass1 = ((EditText)findViewById(R.id.password)).getText().toString();
                String pass2 = ((EditText)findViewById(R.id.passwordConfirm)).getText().toString();
                if(!nomb.equals("") && !correo.equals("") && !pass1.equals("") && !pass2.equals("") && pass2.equals(pass1)){
                    Usuario u = new Usuario(id,correo,nomb, pass1);
                    mDatabase.child("usuarios").child(u.getId()+"").setValue(u);
                    Intent intent = new Intent(v.getContext(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


}
