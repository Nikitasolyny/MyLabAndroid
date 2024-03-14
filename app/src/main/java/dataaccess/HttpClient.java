package dataaccess;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {
    private static final String API_BASE_URL = "https://api.spaceflightnewsapi.net/v4/";

    public static Retrofit retrofit() {
        OkHttpClient client = new OkHttpClient.Builder().build();

        Retrofit result = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  result;
    }
}
