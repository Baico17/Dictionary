package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dictionary.Adapter.AdapterDefinition;
import com.example.dictionary.Adapter.AdapterMeanings;
import com.example.dictionary.Adapter.AdapterPhonetics;
import com.example.dictionary.Models.APIResponse;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    TextView textViewWord;
    RecyclerView recyclerPhonetics, recyclerMeanings;
    ProgressDialog progressDialog;
    AdapterPhonetics adapterPhonetics;
    AdapterMeanings adapterMeanings;
    AdapterDefinition adapterDefinition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView= findViewById(R.id.search_view);
        textViewWord = findViewById(R.id.text_word);
        recyclerMeanings= findViewById(R.id.recycler_meanings);
        recyclerPhonetics = findViewById(R.id.recycler_phonetics);

        //By default first initiation we start with this
        progressDialog.setTitle("Loading");
        progressDialog.show();
        Request request = new Request(MainActivity.this);
        request.getMeaningWord(listener, "welcome");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching response for " + query);
                progressDialog.show();
                Request request = new Request(MainActivity.this);
                request.getMeaningWord(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }
    private final FetchData listener = new FetchData() {
        @Override
        public void onFetchData(APIResponse apiResponse, String message) {
            progressDialog.dismiss();
            if(apiResponse == null){
                Toast.makeText(MainActivity.this,"No data found", Toast.LENGTH_SHORT).show();
            }
            showData(apiResponse);
        }

        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();

        }
    };

    private void showData(APIResponse apiResponse){
        textViewWord.setText("Word" + apiResponse.getWord());
        recyclerPhonetics.setHasFixedSize(true);
        recyclerPhonetics.setLayoutManager(new GridLayoutManager(this,1));
        adapterPhonetics = new AdapterPhonetics(this,apiResponse.getPhonetic());
        recyclerPhonetics.setAdapter(adapterPhonetics);

        //Fill meanings

        recyclerMeanings.setHasFixedSize(true);
        recyclerMeanings.setLayoutManager(new GridLayoutManager(this,1));
        adapterMeanings = new AdapterMeanings(this,apiResponse.getMeanings());
        recyclerMeanings.setAdapter(adapterMeanings);
    }
}