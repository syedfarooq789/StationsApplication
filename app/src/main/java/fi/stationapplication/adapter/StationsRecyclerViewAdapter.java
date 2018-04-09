package fi.stationapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fi.stationapplication.R;
import fi.stationapplication.data.Stations;
import fi.stationapplication.interfaces.IOnItemClickListener;
import fi.stationapplication.recyclerview.StationsRecyclerViewHolder;


public class StationsRecyclerViewAdapter extends RecyclerView.Adapter<StationsRecyclerViewHolder> {
    private List<Stations> stationsList;
    private IOnItemClickListener iOnItemClickListener;
    private EvseRecyclerViewAdapter evseRecyclerViewAdapter;

    public StationsRecyclerViewAdapter(IOnItemClickListener iOnItemClickListener) {
        this.stationsList = new ArrayList<>();
        this.iOnItemClickListener = iOnItemClickListener;
    }

    @Override
    public int getItemCount() {
        return stationsList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull StationsRecyclerViewHolder holder, final int position) {
        final Stations stations = stationsList.get(position);
        holder.textViewLocationName.setText(stations.getName());
        holder.textViewLatLng.setText(stations.getLatitude() + "/" + stations.getLongitude());
        holder.textViewCityName.setText(stations.getCity());
        if (stations.getEvses() != null) {
            this.evseRecyclerViewAdapter = new EvseRecyclerViewAdapter(true);
            holder.recyclerViewEvses.setAdapter(evseRecyclerViewAdapter);
            evseRecyclerViewAdapter.addAll(stations.getEvses());
        }

    }

    /*Creates the view for recycler view*/
    @Override
    public StationsRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ViewGroup mViewGroup = (ViewGroup) layoutInflater.inflate(
                R.layout.stations_recycler_view_item, viewGroup, false);

        final StationsRecyclerViewHolder stationsRecyclerViewHolder = new StationsRecyclerViewHolder(mViewGroup);

        //adding click listener on item view
        stationsRecyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnItemClickListener.onItemClick(v, stationsList.get(stationsRecyclerViewHolder.getAdapterPosition()));
            }
        });

        return stationsRecyclerViewHolder;
    }

    //Adding item in the recycler view
    public void add(final Stations stations) {
        stationsList.add(stations);
        notifyDataSetChanged();
    }

    //Adding all item in the recycler view
    public void addAll(final List<Stations> stationsList) {
        this.stationsList.addAll(stationsList);
        notifyDataSetChanged();
    }

    //Removing item from recycler view
    public void removeAll(final List<Stations> stationsList) {
        stationsList.removeAll(stationsList);
        notifyDataSetChanged();
    }

    public List<Stations> getStationsList() {
        return stationsList;
    }
}
