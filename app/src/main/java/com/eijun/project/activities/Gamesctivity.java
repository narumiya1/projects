package com.eijun.project.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.eijun.project.R;
import com.eijun.project.adapters.GamesAdapter;
import com.eijun.project.data.Contans;
import com.eijun.project.model.DataItemTeam;
import com.eijun.project.model.Games;
import com.eijun.project.model.HomeTeam;
import com.eijun.project.model.VisitorTeam;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Gamesctivity extends AppCompatActivity {

    private List<Games> gamesModel;
    RecyclerView recyclerGame;
    private GamesAdapter adapter;
    private LinearLayoutManager layoutManager;

    private RequestQueue mQueue;

    List<String> fullname ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        recyclerGame = (RecyclerView) findViewById(R.id.recycler_game);
        recyclerGame.setHasFixedSize(true);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerGame.setLayoutManager(layoutManager);

        mQueue = Volley.newRequestQueue(this);

        teamList();
    }

    private void teamList() {
        gamesModel = new ArrayList<>();
        String url = Contans.WEB_URL_TEAM + "games/?per_page=100/";


        JsonObjectRequest request2 = new JsonObjectRequest(Request.Method.GET, url, null,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject games = jsonArray.getJSONObject(i);
                                //model
                                JSONObject visitorTeam = games.getJSONObject("visitor_team");
                                JSONObject homeTeam = games.getJSONObject("home_team");

                                Games gameModel = new Games(
                                        games.getString("id"),
                                        games.getString("home_team_score"),
                                        games.getString("visitor_team_score"),
                                        games.getString("date"),
                                        games.getString("status"),
                                        new VisitorTeam(
                                                visitorTeam.getString("division"),
                                                visitorTeam.getString("conference"),
                                                visitorTeam.getString("full_name"),
                                                visitorTeam.getString("city"),
                                                visitorTeam.getString("name"),
                                                visitorTeam.getInt("id"),
                                                visitorTeam.getString("abbreviation")
                                                ),
                                        new HomeTeam(
                                                homeTeam.getString("division"),
                                                homeTeam.getString("conference"),
                                                homeTeam.getString("full_name"),
                                                homeTeam.getString("city"),
                                                homeTeam.getString("name"),
                                                homeTeam.getInt("id"),
                                                homeTeam.getString("abbreviation"))
                                        );
                                gamesModel.add(gameModel);


                            }

                            adapter = new GamesAdapter(gamesModel, getApplicationContext());
                            recyclerGame.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });
        mQueue.add(request2);
    }
}
