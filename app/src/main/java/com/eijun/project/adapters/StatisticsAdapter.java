package com.eijun.project.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anychart.AnyChartView;
import com.eijun.project.R;
import com.eijun.project.chart.ChartActivity;
import com.eijun.project.model.staats.StaatsModel;

import java.util.List;

public class StatisticsAdapter extends RecyclerView.Adapter<StatisticsAdapter.ViewHolder> {

    private List<StaatsModel> statisticsModel ;
    private Context context ;
    AnyChartView acyChart ;

    public StatisticsAdapter(List<StaatsModel> statisticsModel, Context context) {
        this.statisticsModel = statisticsModel;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_staats, parent,false);
        return new StatisticsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final StaatsModel statisticsM = statisticsModel.get(position);

        holder.first.setText(statisticsM.getPlayer().getFirstName());
        holder.last.setText(statisticsM.getPlayer().getLastName());
        holder.team.setText(statisticsM.getTeam().getFullName());
        holder.position.setText(statisticsM.getPlayer().getPosition());
        holder.home.setText(statisticsM.getGame().getHomeTeamScore());
        holder.visitor.setText(statisticsM.getGame().getVisitorTeamScore());


        holder.assist.setText(statisticsM.getAst());
        holder.block.setText(statisticsM.getBlk());

        holder.dribble.setText(statisticsM.getDreb());
        holder.fga.setText(statisticsM.getFga());
        holder.fta.setText(statisticsM.getFta());
        holder.ftm.setText(statisticsM.getFtm());
        holder.points.setText(statisticsM.getPts());
        holder.rebound.setText(statisticsM.getReb());
        holder.steal.setText(statisticsM.getStl());
        holder.turnover.setText(statisticsM.getTurnover());

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChartActivity.class);
                String first = statisticsModel.get(position).getPlayer().getFirstName();
                intent.putExtra("first", first);
                String assist = statisticsModel.get(position).getAst();
                intent.putExtra("assist", assist);
                String points = statisticsModel.get(position).getPts();
                intent.putExtra("points", points);
                String rebound = statisticsModel.get(position).getReb();
                intent.putExtra("rebound", rebound);
                String dribble = statisticsModel.get(position).getDreb();
                intent.putExtra("dribble", dribble);
                String turnover = statisticsModel.get(position).getTurnover();
                intent.putExtra("turnover", turnover);

                String fga = statisticsModel.get(position).getFga();
                intent.putExtra("fga", fga);
                String steal = statisticsModel.get(position).getStl();
                intent.putExtra("steal", steal);
                String block = statisticsModel.get(position).getBlk();
                intent.putExtra("block", block);
                String ftm = statisticsModel.get(position).getFtm();
                intent.putExtra("ftm", ftm);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return statisticsModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView first, last, team, position,home, visitor, score_home, score_visitor, assist, block, dribble, fga, fta, ftm, points, rebound, steal, turnover ;
        Button button ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            first=itemView.findViewById(R.id.first_name_st);
            last=itemView.findViewById(R.id.last_st);
            team=itemView.findViewById(R.id.team_st);
            position=itemView.findViewById(R.id.position_st);
            home=itemView.findViewById(R.id.home_st);
            visitor=itemView.findViewById(R.id.visitor_st);
            score_home=itemView.findViewById(R.id.home_score_st);
            score_visitor=itemView.findViewById(R.id.visitor_score_st);

            assist=itemView.findViewById(R.id.assist);
            block=itemView.findViewById(R.id.block);
            dribble=itemView.findViewById(R.id.dribble);
            fga=itemView.findViewById(R.id.fga);
            fta=itemView.findViewById(R.id.fta);
            ftm=itemView.findViewById(R.id.ftm);
            points=itemView.findViewById(R.id.pointo);
            rebound=itemView.findViewById(R.id.reboundto);
            steal=itemView.findViewById(R.id.steal);
            turnover=itemView.findViewById(R.id.turnover);
            button =itemView.findViewById(R.id.btn_season_st);

        }
    }
}
