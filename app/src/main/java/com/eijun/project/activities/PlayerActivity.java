package com.eijun.project.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.eijun.project.R;
import com.eijun.project.adapters.PlayerAdapter;
import com.eijun.project.adapters.TeamsAdapter;
import com.eijun.project.data.Contans;
import com.eijun.project.model.DataItemTeam;
import com.eijun.project.model.Player;
import com.eijun.project.model.Team;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PlayerActivity extends AppCompatActivity {

    private List<Player> playersModel;
    RecyclerView recycler;
    private PlayerAdapter adapter;

    private SwipeRefreshLayout swipeRefresh;

    private RequestQueue mQueue;

    private SearchView mSearchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        recycler = (RecyclerView) findViewById(R.id.recycler_player);
        recycler.setHasFixedSize(true);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

        swipeRefresh = findViewById(R.id.swipe_refresh);

        mQueue = Volley.newRequestQueue(this);


        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefresh.setRefreshing(false);
            }
        });
        playerList("");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.searchView);

        mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        mSearchView.setQueryHint("Search ...");
        mSearchView.setIconifiedByDefault(true);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                playerList(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                playerList(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    private void playerList(final String searchWord) {

        playersModel = new ArrayList<>();
        String url = Contans.WEB_URL_TEAM + "players/?per_page=100/";

        JsonObjectRequest request2 = new JsonObjectRequest(Request.Method.GET, url, null,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject player = jsonArray.getJSONObject(i);

                                JSONObject playerTeam = player.getJSONObject("team");

                                String playerName = player.getString("last_name");


                                if (!searchWord.equals("") && playerName.toLowerCase().contains(searchWord.toLowerCase())) {

                                    Player playerModel = new Player(
                                            player.getString("id"),
                                            player.getString("first_name"),
                                            player.getString("last_name"),
                                            player.getString("position"),

                                            new Team(
                                                    playerTeam.getString("division"),
                                                    playerTeam.getString("conference"),
                                                    playerTeam.getString("full_name"),
                                                    playerTeam.getString("city"),
                                                    playerTeam.getString("name"),
                                                    playerTeam.getInt("id"),
                                                    playerTeam.getString("abbreviation"))
                                            );

                                    playersModel.add(playerModel);
                                } else if (searchWord.equals("")) {

                                    Player playerModel = new Player(
                                            player.getString("id"),
                                            player.getString("first_name"),
                                            player.getString("last_name"),
                                            player.getString("position"),
                                            new Team(
                                                    playerTeam.getString("division"),
                                                    playerTeam.getString("conference"),
                                                    playerTeam.getString("full_name"),
                                                    playerTeam.getString("city"),
                                                    playerTeam.getString("name"),
                                                    playerTeam.getInt("id"),
                                                    playerTeam.getString("abbreviation"))
                                    );

                                    playersModel.add(playerModel);
                                }


                            }
                            adapter = new PlayerAdapter(playersModel, getApplicationContext());
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
        mQueue.add(request2);

    }
}
