package com.cnb.learningdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.cnb.learningdagger.models.AdapterEvents;
import com.cnb.learningdagger.network.POService;
import com.cnb.learningdagger.network.response.PublicEventsResponse;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

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
        PublicEventsResponse response = mock();
        adapterEvents.swapData(response);

//        eventsCall = poService.getPublicEvents();
//        eventsCall.enqueue(new Callback<PublicEventsResponse>() {
//            @Override
//            public void onResponse(Call<PublicEventsResponse> call, Response<PublicEventsResponse> response) {
//                adapterEvents.swapData(response.body());
//                Log.d("PublicEventsResponse", response.body().processDescription);
//            }
//
//            @Override
//            public void onFailure(Call<PublicEventsResponse> call, Throwable t) {
//                Log.e("PublicEventsResponse", t.getMessage());
//            }
//        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (eventsCall != null) {
//            eventsCall.cancel();
//        }
    }

    private PublicEventsResponse mock() {
        String json = "{\n" +
                "    \"processStatus\": 200,\n" +
                "    \"resultObject\": {\n" +
                "        \"allEvents\": [\n" +
                "            {\n" +
                "                \"type\": \"movie\",\n" +
                "                \"loginRequired\": false,\n" +
                "                \"locationReqired\": false,\n" +
                "                \"events\": [\n" +
                "                    {\n" +
                "                        \"id\": 1,\n" +
                "                        \"title\": \"Tag\",\n" +
                "                        \"description\": \"Nice movie\",\n" +
                "                        \"imageUrl\": \"http://vodafone.loodos.com/development/image/wee.png\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"id\": 2,\n" +
                "                        \"title\": \"Top gun\",\n" +
                "                        \"description\": \"Very nice movie\",\n" +
                "                        \"imageUrl\": \"http://vodafone.loodos.com/development/image/wee.png\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"id\": 3,\n" +
                "                        \"title\": \"Lord of the Rings\",\n" +
                "                        \"description\": \"Very very nice movie\",\n" +
                "                        \"imageUrl\": \"http://vodafone.loodos.com/development/image/wee.png\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"id\": 4,\n" +
                "                        \"title\": \"Fast & Furious\",\n" +
                "                        \"description\": \"Shitty movie\",\n" +
                "                        \"imageUrl\": \"http://vodafone.loodos.com/development/image/wee.png\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"id\": 5,\n" +
                "                        \"title\": \"A Serbian Movie\",\n" +
                "                        \"description\": \"Not nice movie\",\n" +
                "                        \"imageUrl\": \"http://vodafone.loodos.com/development/image/wee.png\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"processDescription\": \"Success\"\n" +
                "}";
        return new Gson().fromJson(json, PublicEventsResponse.class);
    }
}
