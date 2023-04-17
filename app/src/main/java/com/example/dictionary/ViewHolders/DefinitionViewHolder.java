package com.example.dictionary.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dictionary.R;

public class DefinitionViewHolder extends RecyclerView.ViewHolder {

    public TextView text_synonyms, text_antonyms, text_definition, text_example;
    public DefinitionViewHolder(@NonNull View itemView) {
        super(itemView);

        //Necessary put itemView to find the id inside of recycler ??
        text_definition = itemView.findViewById(R.id.text_synonyms);
        text_synonyms = itemView.findViewById(R.id.text_synonyms);
        text_antonyms = itemView.findViewById(R.id.text_antonyms);
        text_example = itemView.findViewById(R.id.text_example);
    }
}
