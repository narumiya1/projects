package com.eijun.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.eijun.project.activities.Gamesctivity;
import com.eijun.project.activities.PlayerActivity;
import com.eijun.project.activities.StatisticsActivity;
import com.eijun.project.activities.TeamsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_team)
    LinearLayout btnTeam;

    @BindView(R.id.btn_player)
    LinearLayout btnPlayer;

    @BindView(R.id.btn_games)
    LinearLayout btnGames;

    @BindView(R.id.btn_staats)
    LinearLayout btnStaats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_team, R.id.btn_player, R.id.btn_games, R.id.btn_staats})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_team:
                startActivity(new Intent(MainActivity.this, TeamsActivity.class));
                break;
            case R.id.btn_player:
                startActivity(new Intent(MainActivity.this, PlayerActivity.class));
                break;
            case R.id.btn_games:
                startActivity(new Intent(MainActivity.this, Gamesctivity.class));
                break;
            case R.id.btn_staats:
                startActivity(new Intent(MainActivity.this, StatisticsActivity.class));
                break;

        }
    }
}