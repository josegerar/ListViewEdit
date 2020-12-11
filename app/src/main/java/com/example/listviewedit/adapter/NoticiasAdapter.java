package com.example.listviewedit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.listviewedit.R;
import com.example.listviewedit.models.Noticias;

import java.util.List;

public class NoticiasAdapter  extends ArrayAdapter<Noticias> {

    public NoticiasAdapter(Context context, Noticias[] datos){
        super(context, R.layout.lyt_item_noticias, datos);
    }

    public NoticiasAdapter(@NonNull Context context, @NonNull List<Noticias> objects) {
        super(context, R.layout.lyt_item_noticias, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater lyInflater = LayoutInflater.from(getContext());
        View item = lyInflater.inflate(R.layout.lyt_item_noticias,null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.lblTitulo);
        lblTitulo.setText(getItem(position).getTitulo());

        TextView lblSubtitulo = (TextView) item.findViewById(R.id.lblSubTitulo);
        lblSubtitulo.setText(getItem(position).getSubtitulo());

        return item;
    }
}
