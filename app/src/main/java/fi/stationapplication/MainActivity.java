package fi.stationapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import fi.stationapplication.adapter.StationsRecyclerViewAdapter;
import fi.stationapplication.common.Extra;
import fi.stationapplication.data.Stations;
import fi.stationapplication.interfaces.IOnItemClickListener;
import fi.stationapplication.interfaces.IResponseHelper;

public class MainActivity extends AppCompatActivity implements IOnItemClickListener {
    private RecyclerView recyclerViewStations;
    private StationsRecyclerViewAdapter stationsRecyclerViewAdapter;
    private ProgressBar progressBarStations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUI();
        initializeData();
    }

    //adding item click on recycler view item
    @Override
    public void onItemClick(View view, final Object object) {
        Intent intent = new Intent(MainActivity.this, LocationViewActivity.class);
        intent.putExtra(Extra.SELECTED_STATION, (Stations) object);
        startActivity(intent);
    }

    private void initializeUI() {
        recyclerViewStations = findViewById(R.id.recycler_view_stations);
        stationsRecyclerViewAdapter = new StationsRecyclerViewAdapter(this);
        recyclerViewStations.setAdapter(stationsRecyclerViewAdapter);
        progressBarStations = findViewById(R.id.progress_bar_station_loading);
    }

    private void initializeData() {
        VirtaApiRequest.getStations(new IResponseHelper() {
            @Override
            public void getData(Object object) {
                ArrayList<Stations> stationsArrayList = (ArrayList<Stations>) object;
                progressBarStations.setVisibility(View.INVISIBLE);
                stationsRecyclerViewAdapter.addAll(stationsArrayList);
                stationsRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }
}
