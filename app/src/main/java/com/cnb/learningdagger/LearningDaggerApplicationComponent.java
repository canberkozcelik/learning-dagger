package com.cnb.learningdagger;

import com.cnb.learningdagger.network.POService;
import com.squareup.picasso.Picasso;

import dagger.Component;

@Component(modules = {POServiceModule.class, PicassoModule.class})
public interface LearningDaggerApplicationComponent {

    Picasso getPicasso();

    POService getPOService();

}
