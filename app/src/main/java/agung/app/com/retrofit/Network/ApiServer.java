package agung.app.com.retrofit.Network;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import agung.app.com.retrofit.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by agung on 12/11/2017.
 */

public class ApiServer {
    private static final String BASE_API = "http://10.14.164.97:8080";
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_API)
            .callbackExecutor(Executors.newCachedThreadPool())
            .addConverterFactory(GsonConverterFactory.create())
            .client(setupOkHttpClient().build())
            .build();

    private static OkHttpClient.Builder setupOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(10000, TimeUnit.SECONDS);
        httpClient.readTimeout(10000, TimeUnit.SECONDS);
        httpClient.addNetworkInterceptor(new StethoInterceptor());

        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        httpClient.addInterceptor(logging);
        return httpClient;
    }

    private static final UserApi userApi = retrofit.create(UserApi.class);

    static UserApi getUserApi(){
        return userApi;
    }
}
