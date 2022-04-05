package com.example.asg6_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Registration> regList;

    public RecyclerViewAdapter(Context context, ArrayList<Registration> regList) {
        this.context = context;
        this.regList = regList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Registration registration = regList.get(position);

        holder.reg_Id.setText(Integer.toString(registration.getId()));
        holder.reg_name.setText(registration.getName());
        holder.reg_mob.setText(registration.getMob());
    }

    @Override
    public int getItemCount() {
        return regList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView reg_Id;
        public TextView reg_name;
        public TextView reg_mob;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            itemView.setOnClickListener(this);

            reg_Id = itemView.findViewById(R.id.regId);
            reg_name = itemView.findViewById(R.id.name);
            reg_mob = itemView.findViewById(R.id.mob);
        }
    }
}
