package com.bahabakan.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.bahabakan.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<Landmark> landmarkArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // ArrayList'ı başlat
        landmarkArrayList = new ArrayList<>();

        // Data
        Landmark pisa = new Landmark("Pisa", "Italy", R.drawable.pisa);
        Landmark bridge = new Landmark("Bridge", "UK", R.drawable.bridge);
        Landmark eiffel = new Landmark("Eiffel", "France", R.drawable.eiffel);
        Landmark colosseum = new Landmark("Colosseum", "Italy", R.drawable.colosseum);

        landmarkArrayList.add(pisa);
        landmarkArrayList.add(bridge);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(colosseum);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter=new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);
       /*
        // İsimleri toplamak için basit bir döngü kullanın
        ArrayList<String> landmarkNames = new ArrayList<>();
        for (Landmark landmark : landmarkArrayList) {
            landmarkNames.add(landmark.name);
        }

        // Adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, landmarkNames);
        binding.listView.setAdapter(arrayAdapter);

        // ListView tıklama olayını ayarlayın
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
               // Toast.makeText(MainActivity.this, landmarkArrayList.get(position).name, Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("landmark",landmarkArrayList.get(position));

                startActivity(intent);
            }
        });

         */


    }
}
