package com.example.dictionary.Adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.Models.Phonetic;
import com.example.dictionary.R;
import com.example.dictionary.ViewHolders.PhoneticViewHolder;

import java.util.List;

public class AdapterPhonetics extends RecyclerView.Adapter<PhoneticViewHolder> {
    private Context context;
    private List<Phonetic> phoneticList;

    public AdapterPhonetics(Context context, List<Phonetic> phoneticList) {
        this.context = context;
        this.phoneticList = phoneticList;
    }

    @NonNull
    @Override
    public PhoneticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhoneticViewHolder(LayoutInflater.from(context).inflate(R.layout.list_phonetics_items,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticViewHolder holder, int position) {
        holder.textPhonetic.setText(phoneticList.get(position).getText());
        holder.imageButtonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                try{
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    mediaPlayer.setDataSource("https:" + phoneticList.get(position).getAudio());
                    mediaPlayer.prepare();;
                    mediaPlayer.start();
                }catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(context,"The audio it isn´t working", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return phoneticList.size();
    }
}
