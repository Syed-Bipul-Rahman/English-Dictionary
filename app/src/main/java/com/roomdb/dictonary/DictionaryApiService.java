package com.roomdb.dictonary;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DictionaryApiService {
    @GET("api/v2/entries/en/{word}")
    Call<DictionaryResponse> getDefinition(@Path("word") String word);
}