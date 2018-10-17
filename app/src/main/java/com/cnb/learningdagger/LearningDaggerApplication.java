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

        POService poService1 = component.getPOService();
        Picasso picasso1 = component.getPicasso();

        POService poService2 = component.getPOService();
        Picasso picasso2 = component.getPicasso();

        Timber.tag("Dagger2").i("poService" + poService);
        Timber.tag("Dagger2").i("picasso" + picasso);
        Timber.tag("Dagger2").i("poService1" + poService1);
        Timber.tag("Dagger2").i("picasso1" + picasso1);
        Timber.tag("Dagger2").i("poService2" + poService2);
        Timber.tag("Dagger2").i("picasso2" + picasso2);

        /*
        2018-10-17 17:00:11.140 15145-15145/com.cnb.learningdagger I/Dagger2: poServiceretrofit2.Retrofit$1@c70d3c7
        2018-10-17 17:00:11.140 15145-15145/com.cnb.learningdagger I/Dagger2: picassocom.squareup.picasso.Picasso@f7afdf4
        2018-10-17 17:00:11.140 15145-15145/com.cnb.learningdagger I/Dagger2: poService1retrofit2.Retrofit$1@f76a91d
        2018-10-17 17:00:11.140 15145-15145/com.cnb.learningdagger I/Dagger2: picasso1com.squareup.picasso.Picasso@67b0792
        2018-10-17 17:00:11.140 15145-15145/com.cnb.learningdagger I/Dagger2: poService2retrofit2.Retrofit$1@b9ce563
        2018-10-17 17:00:11.140 15145-15145/com.cnb.learningdagger I/Dagger2: picasso2com.squareup.picasso.Picasso@d440560
        */

        /*
        2018-10-17 17:10:52.328 17389-17389/com.cnb.learningdagger I/Dagger2: poServiceretrofit2.Retrofit$1@f0befe1
        2018-10-17 17:10:52.328 17389-17389/com.cnb.learningdagger I/Dagger2: picassocom.squareup.picasso.Picasso@431e106
        2018-10-17 17:10:52.328 17389-17389/com.cnb.learningdagger I/Dagger2: poService1retrofit2.Retrofit$1@f0befe1
        2018-10-17 17:10:52.328 17389-17389/com.cnb.learningdagger I/Dagger2: picasso1com.squareup.picasso.Picasso@431e106
        2018-10-17 17:10:52.329 17389-17389/com.cnb.learningdagger I/Dagger2: poService2retrofit2.Retrofit$1@f0befe1
        2018-10-17 17:10:52.329 17389-17389/com.cnb.learningdagger I/Dagger2: picasso2com.squareup.picasso.Picasso@431e106
        */
    }

    public POService getPoService() {
        return poService;
    }

    public Picasso getPicasso() {
        return picasso;
    }
}
