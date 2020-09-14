package com.eijun.project.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eijun.project.R;
import com.eijun.project.model.DataItemTeam;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    public List<DataItemTeam> teamModels ;
    private Context context ;

    public TeamsAdapter(List<DataItemTeam> teamModel, Context context) {
        this.teamModels = teamModel;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
        return new TeamsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataItemTeam teamMode= teamModels.get(position);

        holder.id_team.setText(teamMode.getId());
        holder.name.setText(teamMode.getName());
        holder.fullname.setText(teamMode.getFullname());
        holder.division.setText(teamMode.getDivision());
        holder.city.setText(teamMode.getCity());

        holder.mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return teamModels.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{

        public TextView id_team, name,fullname,division, city ;
        public View mainView ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainView = itemView ;
            id_team = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            fullname = itemView.findViewById(R.id.fullname);
            division = itemView.findViewById(R.id.division);
            city = itemView.findViewById(R.id.city);

        }
    }
}
