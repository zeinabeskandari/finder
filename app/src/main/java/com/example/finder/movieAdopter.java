package com.example.finder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class movieAdopter extends RecyclerView.Adapter<movieAdopter.VeiwHolder>{
    ArrayList<movie_class> movie_classes;
    public movieAdopter(ArrayList<movie_class> movie_classes){
        this.movie_classes=movie_classes;
    }
    @NonNull
    @Override
    public movieAdopter.VeiwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.movie,parent,false);
        return new VeiwHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull movieAdopter.VeiwHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class VeiwHolder extends RecyclerView.ViewHolder {
        public VeiwHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
