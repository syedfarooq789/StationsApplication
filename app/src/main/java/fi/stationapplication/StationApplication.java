package fi.stationapplication;


import android.app.Application;

import fi.stationapplication.interfaces.IVirtaStationService;

import static fi.stationapplication.common.Extra.VIRTA_API_BASE_URL;

public class StationApplication extends Application {
    private static StationApplication stationApplicationInstance;

    private IVirtaStationService iVirtaStationService;

    public static StationApplication getInstance() {
        return stationApplicationInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        stationApplicationInstance = this;

        iVirtaStationService = RetrofitClient.getClient(VIRTA_API_BASE_URL).create(IVirtaStationService.class);
    }

    public IVirtaStationService getVirtaStationService() {
        return iVirtaStationService;
    }
}
