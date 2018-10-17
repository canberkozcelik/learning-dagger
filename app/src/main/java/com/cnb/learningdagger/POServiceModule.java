package com.cnb.learningdagger;

import com.cnb.learningdagger.network.POService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = NetworkModule.class)
public class POServiceModule {

    @Provides
    @LearningDaggerApplicationScope
    public POService poService(Retrofit retrofit) {
        return retrofit.create(POService.class);
    }

    @Provides
    @LearningDaggerApplicationScope
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @LearningDaggerApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("http://plusone.loodos.com/api/v1.0/")
                .build();
    }
}
