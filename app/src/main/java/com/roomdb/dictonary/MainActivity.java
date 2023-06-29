package com.roomdb.dictonary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
//variables declarations
private EditText searchEditText;
    private Button searchButton;
    private LinearLayout definitionsLayout;
    private TextView statusTextView;
    private DictionaryApiService apiService;
    private DictionaryDao dictionaryDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initializing variables
        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
        definitionsLayout = findViewById(R.id.definitionsLayout);
        statusTextView = findViewById(R.id.statusTextView);

        apiService = retrofit.create(DictionaryApiService.class);
// Create an instance of the Room database
        dictionaryDao = Room.databaseBuilder(getApplicationContext(), DictionaryDatabase.class, "dictionary-db")
                .build()
                .getDictionaryDao();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = searchEditText.getText().toString().trim();
                if (!word.isEmpty()) {
                    searchWord(word);
                }
            }
        });
    }

    private void searchWord(final String word) {
        DictionaryEntry entry = dictionaryDao.getDictionaryEntry(word);
        if (entry != null) {
            displayDefinition(entry.getDefinition());
            return;
        }

        Call<DictionaryResponse> call = apiService.getDefinition(word);
        call.enqueue(new Callback<DictionaryResponse>() {
            @Override
            public void onResponse(Call<DictionaryResponse> call, Response<DictionaryResponse> response) {
                if (response.isSuccessful()) {
                    DictionaryResponse dictionaryResponse = response.body();

                    if (dictionaryResponse != null && dictionaryResponse.getMeanings() != null && !dictionaryResponse.getMeanings().isEmpty()) {
                        List<DictionaryMeaning> meanings = dictionaryResponse.getMeanings();

                        // Save the definition to the database
                        DictionaryMeaning firstMeaning = meanings.get(0);
                        String definition = firstMeaning.getDefinitions().get(0).getDefinition();
                        DictionaryEntry entry = new DictionaryEntry();
                        entry.setWord(word);
                        entry.setDefinition(definition);
                        dictionaryDao.insertDictionaryEntry(entry);

                        displayDefinition(definition);
                    } else {
                        displayErrorMessage("No definition found for the word.");
                    }
                } else {
                    displayErrorMessage("Failed to retrieve definition. Please try again.");
                }
            }

            @Override
            public void onFailure(Call<DictionaryResponse> call, Throwable t) {
                displayErrorMessage("Network request failed. Please check your internet connection.");
            }
        });
    }

    private void displayDefinition(String definition) {
        statusTextView.setVisibility(View.GONE);

        TextView definitionTextView = new TextView(this);
        definitionTextView.setText(definition);
        definitionsLayout.addView(definitionTextView);
    }

    private void displayErrorMessage(String message) {
        statusTextView.setText(message);
        statusTextView.setVisibility(View.VISIBLE);


    }
}