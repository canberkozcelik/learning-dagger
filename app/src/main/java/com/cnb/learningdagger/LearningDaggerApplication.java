package com.cnb.learningdagger;

import android.app.Activity;
import android.app.Application;

import com.cnb.learningdagger.network.POService;
import com.fatboyindustrial.gsonjodatime.DateTimeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import org.joda.time.DateTime;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class LearningDaggerApplication extends Application {

    public static LearningDaggerApplication get(Activity activity) {
        return (LearningDaggerApplication) activity.getApplication();
    }

    private POService poService;

//                              Activity
//          POService                       Picasso
//          Retrofit                        OkHttpDownloader
//          Gson                            OkHttp
//                                      Logger    Cache
//                                      Timber    File

    @Override
    public void onCreate() {
        super.onCreate();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(DateTime.class, new DateTimeConverter());
        Gson gson = gsonBuilder.create();

        Timber.plant(new Timber.DebugTree());

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Picasso picasso = new Picasso.Builder(this)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();

//        Picasso.setSingletonInstance(picasso);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("http://plusone.loodos.com/api/v1.0/")
                .build();

        poService = retrofit.create(POService.class);
    }

    public POService getPoService() {
        return poService;
    }
}
