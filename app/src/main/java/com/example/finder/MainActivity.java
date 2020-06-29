package com.example.finder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private ProgressBar progressBar;
String pUrl="https://image.tmdb.org/t/p/w500/";
private JsonArrayRequest request;
private RequestQueue requestQueue;
private List<movie_class> lstMovie;
private ImageView imageView;
private RecyclerView recyclerView;
private GridLayoutManager gridLayoutManager;
ArrayList<movie_class> movie_classes;
private final String JSON_URL="https://api.themoviedb.org/3/movie/now_playing?api_key=0bdeb6a230e8e5e4f552111d5737e32e";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView.setLayoutManager((new LinearLayoutManager(getApplicationContext())));
        recyclerView.setHasFixedSize(true);
        progressBar=findViewById(R.id.progressMain1);
        recyclerView=findViewById(R.id.rvMain);
        imageView=findViewById(R.id.ivMovieImage1);
        lstMovie=new ArrayList<>();
        requestQueue=Volley.newRequestQueue(this);
        gridLayoutManager=new GridLayoutManager(getApplicationContext(),2);

        getData();
    }
    private void showView(){
        movieAdopter movieAdopter=new movieAdopter(MainActivity.this,movie_classes);
        recyclerView.setAdapter(movieAdopter);
        recyclerView.setLayoutManager(gridLayoutManager);

    }
    public void getData() {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=0bdeb6a230e8e5e4f552111d5737e32e";
        movie_classes= new ArrayList<>();


        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressBar.setVisibility(View.GONE);
                if (response != null) {
                    Log.e("MainActivity", "on Response:" + response);
                    try {
                        JSONArray jsonArray = response.getJSONArray("results");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject data = jsonArray.getJSONObject(i);

                                movie_classes.add(new movie_class(pUrl + data.getString("poster_path"), data.getString("title"), pUrl + data.getString("backdrop_path"), data.getString("overview"), data.getString("release_date")));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        showView();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Log.e("MainActivity","OnResponse:"+error);
            }
        });
        requestQueue.add(jsonObjectRequest);
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                progressBar.setVisibility(View.GONE);
//
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
////                                image.setImageBitmap(jsonObject.getJSONArray());
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                progressBar.setVisibility(View.GONE);
//                Log.d("Error Response", error.toString());
//            }
//        });
//        queue.add(stringRequest);
    }

    }

