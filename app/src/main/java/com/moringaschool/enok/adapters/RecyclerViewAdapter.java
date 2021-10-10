package com.moringaschool.enok.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.enok.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mBodies = new ArrayList<>();
    private ArrayList<String> mLanguages = new ArrayList<>();
    Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mTitles, ArrayList<String> mBodies, ArrayList<String> mLanguages) {
        this.mTitles = mTitles;
        this.mBodies = mBodies;
        this.mLanguages = mLanguages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guestion_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(mTitles.get(position));
        holder.body.setText(mBodies.get(position));
        holder.language.setText(mLanguages.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mTitles.get(position) + " works", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView body;
        TextView language;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
            language = itemView.findViewById(R.id.language);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
