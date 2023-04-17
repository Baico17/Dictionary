package com.example.dictionary;

import android.content.Context;
import android.widget.Toast;

import com.example.dictionary.Models.APIResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class Request {
    Context context;

    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.dictionaryapi.dev/api/v2")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public Request(Context context){
        this.context = context;
    }

    public interface CallDictionary{
        @GET("entries/en/{word}")
        Call<List<APIResponse>> callAPIResponse(@Path("word") String word);
    }

    public void getMeaningWord(FetchData fetchData, String word){
        CallDictionary callDictionary = retrofit.create(CallDictionary.class);
        Call<List<APIResponse>> listCall = callDictionary.callAPIResponse(word);

        //Get the response
        try{
            listCall.enqueue(new Callback<List<APIResponse>>() {
                @Override
                public void onResponse(Call<List<APIResponse>> call, Response<List<APIResponse>> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(context, "We find an error", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    fetchData.onFetchData(response.body().get(0), response.message());
                }

                @Override
                public void onFailure(Call<List<APIResponse>> call, Throwable t) {
                    fetchData.onError("Request failed");

                }
            });
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(context, "We find an error", Toast.LENGTH_SHORT).show();
        }

    }
}
