package com.eijun.project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eijun.project.R;
import com.eijun.project.model.Player;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    private List<Player> playerModels;
    private Context context ;

    public PlayerAdapter(List<Player> playerModel, Context context) {
        this.playerModels = playerModel;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player,parent,false);
        return new PlayerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Player playerMode = playerModels.get(position) ;

        holder.id_player.setText(playerMode.getId());
        holder.firstname.setText(playerMode.getFirst_name());
        holder.lastname.setText(playerMode.getLast_name());
        holder.team.setText(playerMode.getTeamz().getFullName());
        holder.position.setText(playerMode.getPosition());

        holder.mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return playerModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id_player,firstname,lastname,position, team;
        public View mainView ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainView = itemView ;
            id_player=itemView.findViewById(R.id.id_player);
            team = itemView.findViewById(R.id.team);
            firstname=itemView.findViewById(R.id.first_name);
            lastname=itemView.findViewById(R.id.last_name);
            position=itemView.findViewById(R.id.position);

        }
    }
}
