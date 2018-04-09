package fi.stationapplication.interfaces;


import java.util.ArrayList;

import fi.stationapplication.data.Stations;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface IVirtaStationService {
    @Headers({"Content-Type:application/x-www-form-urlencoded",
            "Accept:application/json"})
    @GET("/v4/stations/")
    Call<ArrayList<Stations>> getStations();
}
