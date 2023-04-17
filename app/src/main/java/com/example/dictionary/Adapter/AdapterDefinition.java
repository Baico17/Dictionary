package com.example.dictionary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.Models.Definitions;
import com.example.dictionary.R;
import com.example.dictionary.ViewHolders.DefinitionViewHolder;

import java.util.List;

public class AdapterDefinition extends RecyclerView.Adapter<DefinitionViewHolder> {
    private Context context;
    private List<Definitions> definitionsList;

    public AdapterDefinition(Context context, List<Definitions> definitionsList) {
        this.context = context;
        this.definitionsList = definitionsList;
    }

    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionViewHolder(LayoutInflater.from(context).inflate(R.layout.list_defintions_items,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int position) {
        holder.text_definition.setText("Definition: "+ definitionsList.get(position).getDefinition());
        holder.text_example.setText("Example: " + definitionsList.get(position).getExample());
        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();

        synonyms.append(definitionsList.get(position).getSynonyms());
        antonyms.append(definitionsList.get(position).getAntonyms());

        holder.text_synonyms.setText(synonyms);
        holder.text_antonyms.setText(antonyms);

        holder.text_synonyms.setSelected(true);
        holder.text_antonyms.setSelected(true);

    }

    @Override
    public int getItemCount() {
        return definitionsList.size();
    }
}
