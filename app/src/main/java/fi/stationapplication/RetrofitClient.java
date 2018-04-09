package fi.stationapplication;


import java.util.concurrent.TimeUnit;

import fi.stationapplication.common.Extra;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {
    public static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            //setting timeout details
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .connectTimeout(Extra.TIMEOUT_TIME, TimeUnit.SECONDS)
                    .readTimeout(Extra.TIMEOUT_TIME, TimeUnit.SECONDS)
                    .writeTimeout(Extra.TIMEOUT_TIME, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl).client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
