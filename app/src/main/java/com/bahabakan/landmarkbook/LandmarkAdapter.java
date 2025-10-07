package com.bahabakan.landmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bahabakan.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>{

    ArrayList<Landmark> landmarkList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkList) {
       this.landmarkList=landmarkList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerRowBinding recyclerRowBinding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new LandmarkHolder(recyclerRowBinding);  //viewHolder sınıfı oluşturulduğunda çağrılavak methot(xml i bağlama işlemi yapılacak.)
    }

    @Override
    public void onBindViewHolder(LandmarkAdapter.LandmarkHolder holder,int position) {
        //viewHolder sınıfı bağlandığında neler olacağını gösteren fonksiyon
        holder.binding.recyclerViewTextView.setText(landmarkList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(),DetailsActivity.class);
               // intent.putExtra("Landmark",landmarkArrayList.get(position));
                Singleton singleton=Singleton.getInstance();
                singleton.getSentLandmark(landmarkList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() { //xml in kaç kere oluşturulacağını söyleyecek.
        return landmarkList.size();
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder{

        private RecyclerRowBinding binding;
    public LandmarkHolder(RecyclerRowBinding binding) {
        super(binding.getRoot());

        this.binding=binding;
    }
}

}
