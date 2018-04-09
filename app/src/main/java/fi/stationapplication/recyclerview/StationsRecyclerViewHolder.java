package fi.stationapplication.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fi.stationapplication.R;


public class StationsRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewLocationName;
    public TextView textViewLatLng;
    public TextView textViewCityName;
    public RecyclerView recyclerViewEvses;


    public StationsRecyclerViewHolder(@NonNull View view) {
        super(view);
        textViewLocationName = view.findViewById(R.id.text_view_location_name);
        textViewLatLng = view.findViewById(R.id.text_view_longitude_latitude);
        textViewCityName = view.findViewById(R.id.text_view_city_name);
        recyclerViewEvses = view.findViewById(R.id.recycler_view_evses);
    }
}
