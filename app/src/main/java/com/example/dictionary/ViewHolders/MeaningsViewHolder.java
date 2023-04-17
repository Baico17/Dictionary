package com.example.dictionary.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dictionary.R;

public class MeaningsViewHolder extends RecyclerView.ViewHolder {
    public RecyclerView definitions_recycler;
    public TextView partSpeech;
    public MeaningsViewHolder(@NonNull View itemView) {
        super(itemView);

        definitions_recycler = itemView.findViewById(R.id.definitions_recycler);
        partSpeech = itemView.findViewById(R.id.partSpeech);
    }
}
