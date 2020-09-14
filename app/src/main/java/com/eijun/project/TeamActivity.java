package com.eijun.project;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.eijun.project.adapters.TeamAdapter;
import com.eijun.project.model.DataItemTeam;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.eijun.project.data.Contans.WEB_URL_TEAM;

public class TeamActivity extends AppCompatActivity {

    @BindView(R.id.recycler_team)
    RecyclerView recycler;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private ProgressDialog progressDialog;

    private List<DataItemTeam> listTeam = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        ButterKnife.bind(this);

        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

//        listTeam = new ArrayList<>();

        AndroidNetworking.initialize(getApplicationContext());

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefresh.setRefreshing(false);
            }
        });
        getDataTeam();
    }

    private void getDataTeam() {
        AndroidNetworking.get("https://www.balldontlie.io/api/v1/teams/")
                .setTag(this)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject data = response.getJSONObject(i);
                                listTeam.add(new DataItemTeam(
                                        data.getString("id"),
                                        data.getString("name"),
                                        data.getString("fullname"),
                                        data.getString("division"),
                                        data.getString("city")
                                ));
                            }

                            TeamAdapter adapter = new TeamAdapter(TeamActivity.this, listTeam);
                            recycler.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });
    }

    private void closeProgress() {

        progressDialog.dismiss();
    }

    private void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading . . .");
        progressDialog.show();
    }
}
