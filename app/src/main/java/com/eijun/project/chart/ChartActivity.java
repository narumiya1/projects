package com.eijun.project.chart;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.eijun.project.R;
import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.List;

public class ChartActivity extends AppCompatActivity {

    private TextView firstt, pointt, assist, st_dribble, srebound, turnover, tv_fga, tv_steal, tv_vlock, tv_ftm;

    ScrollView scrollView;
    PieChart pieChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        scrollView = findViewById(R.id.scrollStats);
        pieChart = findViewById(R.id.piechart);

        tv_fga = findViewById(R.id.tv_fga);
        String fga = getIntent().getStringExtra("fga");
        tv_fga.setText(fga);

        tv_steal = findViewById(R.id.tv_steal);
        String steal = getIntent().getStringExtra("steal");
        tv_steal.setText(steal);

        tv_vlock = findViewById(R.id.tv_block);
        String blok = getIntent().getStringExtra("block");
        tv_vlock.setText(blok);

        tv_ftm = findViewById(R.id.tv_ftm);
        String ftm = getIntent().getStringExtra("ftm");
        tv_ftm.setText(ftm);

        firstt = findViewById(R.id.nameplay);
        String firsto = getIntent().getStringExtra("first");
        firstt.setText(firsto);
        firstt.setText(firsto + "\'s stats");

        pointt = findViewById(R.id.points);
        String point = getIntent().getStringExtra("points");
        pointt.setText(point);

        assist = findViewById(R.id.assists);
        String asis = getIntent().getStringExtra("assist");
        assist.setText(asis);

        st_dribble = findViewById(R.id.st_dribble);
        String dribble = getIntent().getStringExtra("dribble");
        st_dribble.setText(dribble);

        srebound = findViewById(R.id.tv_rebound);
        String rebounds = getIntent().getStringExtra("rebound");
        srebound.setText(rebounds);

        turnover = findViewById(R.id.st_turnover);
        String turnoverr = getIntent().getStringExtra("turnover");
        turnover.setText(turnoverr);

        pieChart.addPieSlice(new PieModel("Points", Integer.parseInt(pointt.getText().toString()), Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(new PieModel("Assists", Integer.parseInt(assist.getText().toString()), Color.parseColor("#FFA726")));
        pieChart.addPieSlice(new PieModel("Dribble", Integer.parseInt(st_dribble.getText().toString()), Color.parseColor("#EF5350")));
        pieChart.addPieSlice(new PieModel("Rebound", Integer.parseInt(srebound.getText().toString()), Color.parseColor("#29B6F6")));
        pieChart.addPieSlice(new PieModel("Turnover", Integer.parseInt(turnover.getText().toString()), Color.parseColor("#4527A0")));

        pieChart.addPieSlice(new PieModel("FGA", Integer.parseInt(assist.getText().toString()), Color.parseColor("#B9F6CA")));
        pieChart.addPieSlice(new PieModel("Steal", Integer.parseInt(st_dribble.getText().toString()), Color.parseColor("#FFB74D")));
        pieChart.addPieSlice(new PieModel("Block", Integer.parseInt(srebound.getText().toString()), Color.parseColor("#666666")));
        pieChart.addPieSlice(new PieModel("FTM", Integer.parseInt(turnover.getText().toString()), Color.parseColor("#EC407A")));

        pieChart.startAnimation();
//        pieChart.clearChart();

    }


}
