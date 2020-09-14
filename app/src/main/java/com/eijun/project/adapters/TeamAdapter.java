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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder> {

    Context context;
    List<DataItemTeam> listItem;
//    OnItemClickListener mOnItemClickListener;

//    public interface OnItemClickListener {
//        void onClick(DataItemTeam item);
//    }

    public TeamAdapter(Context context, List<DataItemTeam> listItem) {
        this.context = context;
        this.listItem = listItem;
    }


//    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
//        this.mOnItemClickListener = mItemClickListener;
//    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final DataItemTeam data = listItem.get(position);
        holder.tvNamaTeam.setText(data.getFullname());
        holder.tvDivision.setText(data.getDivision());
        holder.tvCity.setText(data.getCity());
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mOnItemClickListener.onClick(data);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.id)
        TextView tvIndeks;

        @BindView(R.id.fullname)
        TextView tvNamaTeam;

        @BindView(R.id.division)
        TextView tvDivision;

        @BindView(R.id.city)
        TextView tvCity;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
