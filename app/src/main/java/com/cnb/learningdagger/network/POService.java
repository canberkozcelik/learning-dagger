package com.cnb.learningdagger.network;

import com.cnb.learningdagger.network.response.PublicEventsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface POService {

    @GET("Event/Public")
    Call<PublicEventsResponse> getPublicEvents();
}
