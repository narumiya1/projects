package com.eijun.project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eijun.project.R;
import com.eijun.project.model.Statistics;
import com.eijun.project.model.staats.StaatsModel;

import java.util.List;

public class StatisticsAdapter extends RecyclerView.Adapter<StatisticsAdapter.ViewHolder> {

    private List<StaatsModel> statisticsModel ;
    private Context context ;

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
        holder.rebound.setText(statisticsM.getStl());
        holder.steal.setText(statisticsM.getReb());
        holder.turnover.setText(statisticsM.getTurnover());

    }

    @Override
    public int getItemCount() {
        return statisticsModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView first, last, team, position,home, visitor, score_home, score_visitor, assist, block, dribble, fga, fta, ftm, points, rebound, steal, turnover ;
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
            points=itemView.findViewById(R.id.pointo);
            rebound=itemView.findViewById(R.id.reboundto);
            steal=itemView.findViewById(R.id.steal);
            turnover=itemView.findViewById(R.id.turnover);
        }
    }
}
