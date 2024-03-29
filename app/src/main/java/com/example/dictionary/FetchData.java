package com.example.dictionary;

import com.example.dictionary.Models.APIResponse;

public interface FetchData {
    void onFetchData(APIResponse apiResponse, String message);
    void onError(String message);
}
