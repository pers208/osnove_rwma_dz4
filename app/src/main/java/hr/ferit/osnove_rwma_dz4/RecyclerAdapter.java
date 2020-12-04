package hr.ferit.osnove_rwma_dz4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hr.ferit.osnove_rwma_dz3.R;

public class RecyclerAdapter<M> extends RecyclerView.Adapter<MakeupViewHolder> {
    private final Context context;
    private ArrayList<Makeup> dataList=new ArrayList<>();

    public RecyclerAdapter(Context context, ArrayList<Makeup> dataList) {
        this.context = context;
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public MakeupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View cellView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_name,parent,false);
       return new MakeupViewHolder(cellView);
    }

    @Override
    public void onBindViewHolder(@NonNull MakeupViewHolder holder, int position) {
        holder.setItem(dataList.get(position));

    }

    @Override
    public int getItemCount() {
        return  dataList.size();
    }
    public void addData(ArrayList<Makeup> data){
        this.dataList.clear();
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }
}
