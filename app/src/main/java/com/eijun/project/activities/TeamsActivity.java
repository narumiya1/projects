package com.eijun.project.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.eijun.project.R;
import com.eijun.project.adapters.TeamsAdapter;
import com.eijun.project.data.Contans;
import com.eijun.project.model.DataItemTeam;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TeamsActivity extends AppCompatActivity {

    private List<DataItemTeam> teamsModel;
    RecyclerView recycler;
    private TeamsAdapter adapter ;
    private LinearLayoutManager layoutManager;

    private RequestQueue mQueue ;

    private SearchView mSearchView ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);


        recycler = (RecyclerView) findViewById(R.id.recycler_team);
        recycler.setHasFixedSize(true);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(layoutManager);

        mQueue = Volley.newRequestQueue(this);

        teamList("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem searchItem = menu.findItem(R.id.searchView);

        mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        mSearchView.setQueryHint("League...");
        mSearchView.setIconifiedByDefault(true);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                teamList(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                teamList(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    private void teamList(final String searchWord) {

        teamsModel = new ArrayList<>();
        String url = Contans.WEB_URL_TEAM+"teams/";


        JsonObjectRequest request2 = new JsonObjectRequest(Request.Method.GET, url, null,
                new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            for (int i=0 ; i< jsonArray.length(); i++){
                                JSONObject teams = jsonArray.getJSONObject(i);
                                String teamName = teams.getString("full_name");

                                if (!searchWord.equals("") && teamName.toLowerCase().contains(searchWord.toLowerCase())){
                                    DataItemTeam teamModel = new DataItemTeam(
                                            teams.getString("id"),
                                            teams.getString("name"),
                                            teams.getString("full_name"),
                                            teams.getString("city"),
                                            teams.getString("division")
                                    );
                                    teamsModel.add(teamModel);
                                }else if (searchWord.equals("")){
                                    DataItemTeam teamModel = new DataItemTeam(
                                            teams.getString("id"),
                                            teams.getString("name"),
                                            teams.getString("full_name"),
                                            teams.getString("city"),
                                            teams.getString("division")
                                    );
                                    teamsModel.add(teamModel);
                                }

                            }

                            adapter = new TeamsAdapter(teamsModel, getApplicationContext());
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
