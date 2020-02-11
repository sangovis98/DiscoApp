package com.example.discoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.discoapp.modelo.Discoteca;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private Context context;
    private ArrayList<Discoteca> listItems;

    public Adaptador(Context context, ArrayList<Discoteca> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Discoteca Item = (Discoteca) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

        ImageView imgFoto = convertView.findViewById(R.id.imageView);
        TextView titulo = convertView.findViewById(R.id.tituloItem);
        TextView contenido = convertView.findViewById(R.id.descripcionItem);

        imgFoto.setImageResource(convertView.getResources().getIdentifier(Item.getImgRuta(),"drawable", "com.example.discoapp"));
        titulo.setText(Item.getNombre());
        contenido.setText(Item.getDescripcion());
        return convertView;
    }
}
