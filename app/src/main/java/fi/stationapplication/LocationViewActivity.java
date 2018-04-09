package fi.stationapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import fi.stationapplication.adapter.EvseRecyclerViewAdapter;
import fi.stationapplication.common.Extra;
import fi.stationapplication.data.Stations;

public class LocationViewActivity extends AppCompatActivity {
    private RecyclerView recyclerViewEvses;
    private EvseRecyclerViewAdapter evseRecyclerViewAdapter;
    private TextView textViewLocationName;
    private TextView textViewLatLng;
    private TextView textViewCityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_view);

        initializeUI();
        initializeData();
    }

    private void initializeUI() {
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        recyclerViewEvses = findViewById(R.id.recycler_view_location_evses);

        //Create custom action bar
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.common_location_layout, null);
        actionBar.setCustomView(mCustomView);
        actionBar.setDisplayShowCustomEnabled(true);


        //initialize action bar UI
        textViewLocationName = findViewById(R.id.text_view_location_name);
        textViewLatLng = findViewById(R.id.text_view_longitude_latitude);
        textViewCityName = findViewById(R.id.text_view_city_name);
    }

    private void initializeData() {
        evseRecyclerViewAdapter = new EvseRecyclerViewAdapter(false);
        recyclerViewEvses.setAdapter(evseRecyclerViewAdapter);

        //getting data from MainActivity
        Stations stations = (Stations) getIntent().getSerializableExtra(Extra.SELECTED_STATION);
        evseRecyclerViewAdapter.addAll(stations.getEvses());

        //set Textviews
        textViewLocationName.setText(stations.getName());
        textViewLatLng.setText(stations.getLatitude() + "/" + stations.getLongitude());
        textViewCityName.setText(stations.getCity());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
