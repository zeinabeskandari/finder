package com.example.finder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class movieAdopter extends RecyclerView.Adapter<movieAdopter.VeiwHolder>{
    ArrayList<movie_class> movie_classes;
    private Context context;
    public movieAdopter(ArrayList<movie_class> movie_classes,Context context){

        this.movie_classes=movie_classes;
        this.context=context;
    }


    public movieAdopter(MainActivity mainActivity, List<movie_class> lstMovie) {
    }

    @NonNull
    @Override
    public movieAdopter.VeiwHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.movie,parent,false);
        return new VeiwHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull movieAdopter.VeiwHolder holder, int position) {
        Glide.with(context).load(movie_classes.get(position).getImage().into(holder.img));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class VeiwHolder extends RecyclerView.ViewHolder {
        ImageView imageView,backdrop;
        TextView name,summary;
        private LinearLayout linearLayout;

        public VeiwHolder(@NonNull View itemView) {
            super(itemView);
           // linearLayout=itemView.findViewById(R.id.con)
            name=itemView.findViewById(R.id.tvMovieName);
            summary=itemView.findViewById(R.id.tvSummary);
            imageView=itemView.findViewById(R.id.ivMovieImage2);
            backdrop=itemView.findViewById(R.id.ivMovieImage1);
            @Override
                    public void click(View v){

            }

        }

    }
}
