package com.example.discoapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.discoapp.Adaptador;
import com.example.discoapp.DiscoActivity;
import com.example.discoapp.R;
import com.example.discoapp.modelo.Discoteca;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    public ArrayList<Discoteca> discotecas = new ArrayList<Discoteca>();
    private DatabaseReference mDatabase;

    private ListView lista;
    private Adaptador adaptador;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.textHome);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference uidRef = mDatabase.child("discotecas");

        /** Codigo para insertar una discoteca, cambiad datos del constructor e incrementa el id por 1
         Discoteca d = new Discoteca(3, "MoonDance", "imgRuta",rate, latitud, longitud);
         mDatabase.child("discotecas").child(disco.getId()).setValue(disco);
         */
        uidRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> list = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    discotecas.add(ds.getValue(Discoteca.class));
                    list.add(ds.child("nombre").getValue(String.class));
                }
                ListView listView = getActivity().findViewById(R.id.ListaDiscotecas);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, list);
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(view.getContext(), DiscoActivity.class);
                        Discoteca disco = discotecas.get(position);
                        intent.putExtra("disco", disco);
                        startActivity(intent);
                    }
                });

                lista = getActivity().findViewById(R.id.ListaDiscotecas);
                adaptador = new Adaptador(getActivity().getApplicationContext(), discotecas);
                lista.setAdapter(adaptador);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
            /** Para introducir manualmente discotecas
             private ArrayList<Discoteca> getArrayItems(){
             ArrayList<Discoteca> list = new ArrayList<>();
             list.add(new Discoteca(R.drawable.moondance, "Moondance", "Electrónica"));
             list.add(new Discoteca(R.drawable.independance, "Independace","Rock/House"));
             list.add(new Discoteca(R.drawable.fabrik, "Fabrik","Color Electro/House"));

             return list;
             }
             */
        });
    }
}