package fi.stationapplication;


import android.util.Log;

import java.util.ArrayList;

import fi.stationapplication.data.Stations;
import fi.stationapplication.interfaces.IResponseHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VirtaApiRequest {
    public static void getStations(final IResponseHelper iResponseHelper) {
        StationApplication.getInstance()
                .getVirtaStationService().getStations()
                .enqueue(new Callback<ArrayList<Stations>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Stations>> call, Response<ArrayList<Stations>> response) {
                        if (response.isSuccessful()) {
                            //getting the response and placing in callback interface
                            iResponseHelper.getData(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Stations>> call, Throwable t) {
                        Log.d("ERROR", "Failed Get Request " + t.getMessage());
                    }
                });
    }
}
