package com.example.listviewedit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] datos = new String[]{"Element 1","Element 2" ,"Element 3","Element 4","Element 5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);

        Spinner cbOpciones = (Spinner)findViewById(R.id.cbOpciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cbOpciones.setAdapter(adapter);
        cbOpciones.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        ListView listItems =(ListView)findViewById(R.id.listItems);
        listItems.setAdapter(adapter2);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView txtoselecionado = (TextView)findViewById(R.id.txtItemSeleccionado);
        txtoselecionado.setText(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        TextView txtoselecionado = (TextView)findViewById(R.id.txtItemSeleccionado);
        txtoselecionado.setText("");
    }
}