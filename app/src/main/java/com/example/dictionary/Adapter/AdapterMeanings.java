package com.example.dictionary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.Models.Meaning;
import com.example.dictionary.R;
import com.example.dictionary.ViewHolders.MeaningsViewHolder;
import com.example.dictionary.ViewHolders.PhoneticViewHolder;

import java.util.List;

public class AdapterMeanings extends RecyclerView.Adapter<MeaningsViewHolder> {
    private Context context;
    protected List<Meaning> meaningList;

    public AdapterMeanings(Context context, List<Meaning> meaningList) {
        this.context = context;
        this.meaningList = meaningList;
    }

    @NonNull
    @Override
    public MeaningsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningsViewHolder(LayoutInflater.from(context).inflate(R.layout.meanings_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningsViewHolder holder, int position) {
        holder.partSpeech.setText("Parts of Speech: "+ meaningList.get(position).getPartOfSpeech());
        holder.definitions_recycler.setHasFixedSize(true);
        holder.definitions_recycler.setLayoutManager(new GridLayoutManager(context,1));

        AdapterDefinition adapterDefinition = new AdapterDefinition(context,meaningList.get(position).getDefinitions());
        holder.definitions_recycler.setAdapter(adapterDefinition);

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
