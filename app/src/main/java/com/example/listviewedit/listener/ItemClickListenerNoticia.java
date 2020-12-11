package com.example.listviewedit.listener;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.listviewedit.models.Noticias;

public class ItemClickListenerNoticia implements AdapterView.OnItemClickListener {

    private Context context;

    public ItemClickListenerNoticia(Context context) {
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this.context,
                ((Noticias) parent.getItemAtPosition(position)).getTitulo(),
                Toast.LENGTH_LONG).show();
    }
}
