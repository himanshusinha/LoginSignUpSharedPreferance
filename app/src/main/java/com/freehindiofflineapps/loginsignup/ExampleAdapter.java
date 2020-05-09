package com.freehindiofflineapps.loginsignup;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<User> userArrayList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewLine1;
        public TextView mTextViewLine2;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mTextViewLine1 = itemView.findViewById(R.id.lblName);
            mTextViewLine2 = itemView.findViewById(R.id.lblEmail);
        }
    }

    public ExampleAdapter(ArrayList<User> exampleList) {
        userArrayList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        User userlist = userArrayList.get(position);

        holder.mTextViewLine1.setText(userlist.getName());
        holder.mTextViewLine2.setText(userlist.getEmail());
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }
}