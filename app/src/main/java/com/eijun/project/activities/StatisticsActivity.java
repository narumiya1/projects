package com.eijun.project.activities;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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
import com.eijun.project.adapters.StatisticsAdapter;
import com.eijun.project.data.Contans;
import com.eijun.project.model.staats.Game;
import com.eijun.project.model.staats.Player;
import com.eijun.project.model.staats.StaatsModel;
import com.eijun.project.model.staats.Team;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StatisticsActivity extends AppCompatActivity {

    private List<StaatsModel> statisticsModel;
    RecyclerView recycler;
    private RequestQueue requestQueue;
    private StatisticsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staats);

        recycler = (RecyclerView) findViewById(R.id.recycler_staats);
        recycler.setHasFixedSize(true);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        requestQueue = Volley.newRequestQueue(this);
        staatsList();


    }

    private void staatsList() {
        statisticsModel = new ArrayList<>();
        int season = 2018 ;
        String player_ids = "&player_ids[]=1";
        String url = Contans.WEB_URL_TEAM + "stats/?seasons[]="+season+"/";

        JsonObjectRequest request2 = new JsonObjectRequest(Request.Method.GET, url, null,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject staats = jsonArray.getJSONObject(i);
                                //model
                                JSONObject player = staats.getJSONObject("player");

                                JSONObject game = staats.getJSONObject("game");
                                JSONObject team = staats.getJSONObject("team");


                                StaatsModel staatModel = new StaatsModel(

                                        staats.getString("blk"),
                                        staats.getString("fg3a"),
                                        staats.getString("fga"),
                                        staats.getString("ast"),
                                        staats.getString("dreb"),
                                        staats.getString("fg_pct"),
                                        staats.getString("stl"),
                                        staats.getString("fgm"),
                                        staats.getString("ft_pct"),
                                        staats.getString("fg3_pct"),
                                        staats.getString("pts"),
                                        staats.getString("reb"),
                                        staats.getString("fta"),
                                        staats.getString("fg3m"),
                                        staats.getString("id"),
                                        staats.getString("turnover"),
                                        staats.getString("ftm"),


                                        new Game(
                                                game.getString("date"),
                                                game.getInt("home_team_id"),
                                                game.getInt("visitor_team_id"),
                                                game.getInt("season"),
                                                game.getString("visitor_team_score"),
                                                game.getInt("id"),
                                                game.getString("home_team_score")
                                        ),
                                        new Team(
                                                team.getString("division"),
                                                team.getString("conference"),
                                                team.getString("full_name"),
                                                team.getString("city"),
                                                team.getString("name"),
                                                team.getInt("id"),
                                                team.getString("abbreviation")
                                        ),
                                        new Player(
                                                player.getString("last_name"),
                                                player.getInt("id"),
                                                player.getString("position"),
                                                player.getInt("team_id"),
                                                player.getString("first_name")
                                        )


                                );

                                statisticsModel.add(staatModel);

                            }

                            adapter = new StatisticsAdapter(statisticsModel, getApplicationContext());
                            recycler.setAdapter(adapter);
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

        requestQueue.add(request2);

    }
}
