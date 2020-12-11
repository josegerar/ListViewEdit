package com.example.listviewedit;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listviewedit.adapter.NoticiasAdapter;
import com.example.listviewedit.controller.NoticiasController;
import com.example.listviewedit.listener.ItemClickListenerNoticia;
import com.example.listviewedit.models.Noticias;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    public Noticias[] noticias = new Noticias[]{
            new Noticias("Noticia 1", "Contenido noticia 1"),
            new Noticias("Noticia 2", "Contenido noticia 2"),
            new Noticias("Noticia 3", "Contenido noticia 3"),
            new Noticias("Noticia 4", "Contenido noticia 4"),
            new Noticias("Noticia 5", "Contenido noticia 5"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        NoticiasController noticiasController = new NoticiasController(this);
        SystemClock.sleep(2000);

        Context context = this;

        Thread hilo = new Thread(){
            @Override
            public void run() {
                try {

                    while (!noticiasController.isData()){
                        Thread.sleep(100);
                    }
                    NoticiasAdapter noticiasAdapter = new NoticiasAdapter(context, noticiasController.getNoticias());

                    ListView listaNoticias = (ListView)findViewById(R.id.lstNoticias);
                    listaNoticias.setAdapter(noticiasAdapter);
                    listaNoticias.setOnItemClickListener(new ItemClickListenerNoticia(context));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        hilo.start();

    }
}