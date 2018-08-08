package com.cnb.learningdagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.cnb.learningdagger.models.AdapterEvents;
import com.cnb.learningdagger.network.POService;
import com.cnb.learningdagger.network.response.PublicEventsResponse;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.event_list)
    ListView evenListView;

    POService poService;
    private Picasso picasso;

    Call<PublicEventsResponse> eventsCall;

    AdapterEvents adapterEvents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        poService = LearningDaggerApplication.get(this).getPoService();
        picasso = LearningDaggerApplication.get(this).getPicasso();
        adapterEvents = new AdapterEvents(this, picasso);
        evenListView.setAdapter(adapterEvents);

        eventsCall = poService.getPublicEvents();
        eventsCall.enqueue(new Callback<PublicEventsResponse>() {
            @Override
            public void onResponse(Call<PublicEventsResponse> call, Response<PublicEventsResponse> response) {
                adapterEvents.swapData(response.body());
                Log.d("PublicEventsResponse", response.body().processDescription);
            }

            @Override
            public void onFailure(Call<PublicEventsResponse> call, Throwable t) {
                Log.e("PublicEventsResponse", t.getMessage());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (eventsCall != null) {
            eventsCall.cancel();
        }
    }
}
