package fi.stationapplication.recyclerview;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import fi.stationapplication.R;

public class EvseRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewStationPower;
    public TextView textViewStationPowerUnit;

    public EvseRecyclerViewHolder(@NonNull View view) {
        super(view);
        textViewStationPower = view.findViewById(R.id.text_view_power);
        textViewStationPowerUnit = view.findViewById(R.id.text_view_power_unit);
    }
}
