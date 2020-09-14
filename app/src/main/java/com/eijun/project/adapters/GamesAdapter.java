package com.eijun.project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eijun.project.R;
import com.eijun.project.model.Games;
import com.eijun.project.model.Player;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder>{
    private List<Games> gameModels;
    private Context context ;

    public GamesAdapter(List<Games> gameModel, Context context) {
        this.gameModels = gameModel;
        this.context = context;
    }

    @NonNull
    @Override
    public GamesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_games,parent,false);
        return new GamesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Games gameMode = gameModels.get(position) ;

        holder.id_game.setText(gameMode.getId());
        holder.home_team_score.setText(gameMode.getHome_team_score());
        holder.away_team_score.setText(gameMode.getAway_team_score());
        holder.home_team_name.setText(gameMode.getHome_team().getName());
        holder.away_team_name.setText(gameMode.getVisitor_team().getName());
        holder.mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return gameModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id_game,home_team_score,away_team_score, home_team_name, away_team_name;
        public View mainView ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainView = itemView ;
            id_game=itemView.findViewById(R.id.id_geam);
            home_team_score=itemView.findViewById(R.id.home_team_score);
            away_team_score=itemView.findViewById(R.id.away_team_score);

            home_team_name=itemView.findViewById(R.id.home_team_name);
            away_team_name=itemView.findViewById(R.id.away_team_name);


        }
    }
}
