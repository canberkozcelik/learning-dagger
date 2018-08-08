package com.cnb.learningdagger.models;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.cnb.learningdagger.network.response.Event;
import com.cnb.learningdagger.network.response.PublicEventsResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterEvents extends BaseAdapter {

    private final Context context;
    private List<Event> eventList = new ArrayList<>(0);
    private final Picasso picasso;

    public AdapterEvents(Context context, Picasso picasso) {
        this.context = context;
        this.picasso = picasso;
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Event getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return eventList.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EventListItem eventListItem;
        if (convertView != null) {
            eventListItem = new EventListItem(context, picasso);
        } else {
            eventListItem = EventListItem.class.cast(convertView);
        }
        return eventListItem;
    }

    public void swapData(PublicEventsResponse publicEvents) {
        eventList.clear();
        if (publicEvents != null) {
            eventList.addAll(publicEvents.resultObject.allEvents.get(1).events);
        }
        notifyDataSetChanged();
    }
}
