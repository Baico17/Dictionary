package com.example.dictionary.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dictionary.R;

public class PhoneticViewHolder extends RecyclerView.ViewHolder {
    public TextView textPhonetic;
    public ImageButton imageButtonAudio;

    public PhoneticViewHolder(@NonNull View itemView) {
        super(itemView);
        textPhonetic = itemView.findViewById(R.id.text_phonetics);
        imageButtonAudio=itemView.findViewById(R.id.imageButtonAudio);

    }
}
