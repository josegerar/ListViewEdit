package com.example.listviewedit.controller;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.listviewedit.models.Noticias;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NoticiasController {

    private Context context;
    private ArrayList<Noticias> noticias;
    private boolean isData;

    public NoticiasController(Context context) {
        this.context = context;
        noticias = new ArrayList<>();
        this.isData = false;
        this.getDataVolley();
    }

    public boolean isData() {
        return isData;
    }

    public void setData(boolean data) {
        isData = data;
    }

    public ArrayList<Noticias> getNoticias() {
        return noticias;
    }

    public void setNoticias(ArrayList<Noticias> noticias) {
        this.noticias = noticias;
    }

    public void getDataVolley(){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="https://api.covid19api.com/summary";

        JsonObjectRequest josnObjectRequest  = new JsonObjectRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("Countries");
                            for(int i=0;i<jsonArray.length();i++){
                                // Get current json object
                                JSONObject student = jsonArray.getJSONObject(i);

                                // Get the current student (json object) data
                                String country = student.getString("Country");
                                String totalConfirmed = student.getString("TotalConfirmed");
                                String totalDeaths = student.getString("TotalDeaths");
                                String totalRecovered = student.getString("TotalRecovered");
                                String date = student.getString("Date");

                                noticias.add(new Noticias(country,
                                        "Total confirmed: " + totalConfirmed +
                                        ", Total Deaths: " + totalDeaths +
                                        ", Total Recovered: " + totalRecovered +
                                        ", Date: " + date));
                            }

setData(true);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(josnObjectRequest);
    }

}
