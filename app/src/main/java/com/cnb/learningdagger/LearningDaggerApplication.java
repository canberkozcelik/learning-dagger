package com.cnb.learningdagger;

import android.app.Activity;
import android.app.Application;

import com.cnb.learningdagger.network.POService;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

public class LearningDaggerApplication extends Application {

    public static LearningDaggerApplication get(Activity activity) {
        return (LearningDaggerApplication) activity.getApplication();
    }

    private POService poService;
    private Picasso picasso;

//    Dependencies:
//                              Activity
//          POService                       Picasso
//          Retrofit                        OkHttpDownloader
//          Gson                            OkHttp
//                                      Logger    Cache
//                                      Timber    File

//    Groups -> [picasso, okhttpdownloader],[gson, retrofit, poservice], [okhttp, logger, cache, timber, file]

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        LearningDaggerApplicationComponent component = DaggerLearningDaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
//                .pOServiceModule(new POServiceModule())
//                .networkModule(new NetworkModule())
//                .picassoModule(new PicassoModule())
                .build();

        poService = component.getPOService();
        picasso = component.getPicasso();
    }

    public POService getPoService() {
        return poService;
    }

    public Picasso getPicasso() {
        return picasso;
    }
}
