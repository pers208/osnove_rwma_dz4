package hr.ferit.osnove_rwma_dz4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import hr.ferit.osnove_rwma_dz3.R;

public class MakeupViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView name;
    private TextView price;
    private TextView rating;
    private TextView description;


    public MakeupViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.image);
        name=itemView.findViewById(R.id.name);
        price=itemView.findViewById(R.id.price);
        rating=itemView.findViewById(R.id.rating);
        description=itemView.findViewById(R.id.description);
    }
    public void setItem(Makeup makeup){
        setName("Name: "+makeup.getName());
        setPrice("Price: "+makeup.getPrice());
        setRating("Rating: "+makeup.getRating());
        setDescription("Description: "+makeup.getDescription().replace("\n"," ").replace("\t",""));
        setImageView(makeup.getImage_link());
    }
    public void setName(String name){
        this.name.setText(name);
    }
    public void setPrice(String price){
        this.price.setText(price);
    }
    public void setRating(String rating){
        this.rating.setText(rating);
    }
    public void setDescription(String description){
        this.description.setText(description);
    }
    public void setImageView(String link){
        Picasso.get().load(link).into(imageView);
    }
}
