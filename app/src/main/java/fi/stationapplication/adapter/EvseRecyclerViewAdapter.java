package fi.stationapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import fi.stationapplication.R;
import fi.stationapplication.common.Extra;
import fi.stationapplication.data.Evse;
import fi.stationapplication.recyclerview.EvseRecyclerViewHolder;

public class EvseRecyclerViewAdapter extends RecyclerView.Adapter<EvseRecyclerViewHolder> {
    private List<Evse> evseList;
    private boolean isRecyclerViewHorizontal = false;

    public EvseRecyclerViewAdapter(boolean isRecyclerViewHorizontal) {
        this.isRecyclerViewHorizontal = isRecyclerViewHorizontal;
        this.evseList = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return evseList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull EvseRecyclerViewHolder holder, final int position) {
        final Evse evse = evseList.get(position);

        //showing the power of stations in textview
        if (evse.getConnectors() != null) {
            holder.textViewStationPower.setText(evse.getConnectors().get(0).getMaxKw().toString());
        }
        if (!isRecyclerViewHorizontal) {
            RelativeLayout.LayoutParams layoutParamsTextView = (RelativeLayout.LayoutParams) holder.textViewStationPower.getLayoutParams();
            layoutParamsTextView.width = RelativeLayout.LayoutParams.MATCH_PARENT;
            holder.textViewStationPower.setLayoutParams(layoutParamsTextView);

            RecyclerView.LayoutParams layoutParamsView = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
            layoutParamsView.setMargins(Extra.MARGIN, Extra.MARGIN, Extra.MARGIN, Extra.MARGIN);
            holder.itemView.setLayoutParams(layoutParamsView);

        }

    }

    @Override
    public EvseRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ViewGroup mViewGroup = (ViewGroup) layoutInflater.inflate(
                R.layout.evse_recycler_view_item, viewGroup, false);


        final EvseRecyclerViewHolder evseRecyclerViewHolder = new EvseRecyclerViewHolder(mViewGroup);
        return evseRecyclerViewHolder;
    }

    //Adding all item in the recycler view
    public void addAll(final List<Evse> evseList) {
        this.evseList.addAll(evseList);
        notifyDataSetChanged();
    }
}
