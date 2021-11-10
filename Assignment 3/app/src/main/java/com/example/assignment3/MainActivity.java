package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] items = {"The Weather", "Facts About Me", "Investment Portfolio", "My Resume", "More Facts About Me"};
    AutoCompleteTextView autoCompleteText;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteText = findViewById(R.id.autoCompleteTextView);

        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, items);

        autoCompleteText.setAdapter(adapterItems);

        autoCompleteText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Item: "+item, Toast.LENGTH_SHORT).show();

                if (adapterView.getItemAtPosition(i).equals("The Weather"))
                {
                    Intent weather = new Intent(MainActivity.this, TheWeather.class);
                    startActivity(weather);
                }
                else if (adapterView.getItemAtPosition(i).equals("Facts About Me"))
                {
                    Intent facts = new Intent(MainActivity.this, FactsAboutMe.class);
                    startActivity(facts);
                }
                else if (adapterView.getItemAtPosition(i).equals("Investment Portfolio"))
                {
                    Intent investment = new Intent(MainActivity.this, InvestmentPortfolio.class);
                    startActivity(investment);
                }
                else if (adapterView.getItemAtPosition(i).equals("My Resume"))
                {
                    Intent resume = new Intent(MainActivity.this, MyResume.class);
                    startActivity(resume);
                }
                else if (adapterView.getItemAtPosition(i).equals("More Facts About Me"))
                {
                    Intent more = new Intent(MainActivity.this, MoreFactsAboutMe.class);
                    startActivity(more);
                }
            }
        });
    }
}