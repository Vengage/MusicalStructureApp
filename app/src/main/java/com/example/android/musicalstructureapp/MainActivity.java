package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView artistsTextView;
    private TextView albumsTextView;
    private TextView playlistsTextView;

    private ListView artistsListView;
    private ListView albumsListView;
    private ListView playlistsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        artistsTextView = (TextView) findViewById(R.id.artistsTextView);
        artistsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchList(1);
            }
        });

        albumsTextView = (TextView) findViewById(R.id.albumsTextView);
        albumsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchList(2);
            }
        });

        playlistsTextView = (TextView) findViewById(R.id.playlistsTextView);
        playlistsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchList(3);
            }
        });


        artistsListView = (ListView) findViewById(R.id.artistsListView);
        albumsListView = (ListView) findViewById(R.id.albumsListView);
        playlistsListView = (ListView) findViewById(R.id.playlistsListView);

        artistsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent playSong = new Intent(MainActivity.this, NowPlaying.class);
                startActivity(playSong);
            }
        });

        albumsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent playSong = new Intent(MainActivity.this, NowPlaying.class);
                startActivity(playSong);
            }
        });

        playlistsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent playSong = new Intent(MainActivity.this, NowPlaying.class);
                startActivity(playSong);
            }
        });
    }

    private void switchList(int listNumber) {
        switch (listNumber) {
            case 1: {
                artistsListView.setVisibility(View.VISIBLE);
                albumsListView.setVisibility(View.GONE);
                playlistsListView.setVisibility(View.GONE);
                break;
            }
            case 2: {
                artistsListView.setVisibility(View.GONE);
                albumsListView.setVisibility(View.VISIBLE);
                playlistsListView.setVisibility(View.GONE);
                break;
            }
            case 3: {
                artistsListView.setVisibility(View.GONE);
                albumsListView.setVisibility(View.GONE);
                playlistsListView.setVisibility(View.VISIBLE);
                break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.search:{
                Intent launchSearch = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(launchSearch);
                return true;
            }
        }
        return true;
    }
}
