package com.cnb.learningdagger.models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.cnb.learningdagger.R;
import com.cnb.learningdagger.network.response.Event;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("ViewConstructor")
public class EventListItem extends FrameLayout {

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.description)
    TextView description;

    @BindView(R.id.event_image)
    ImageView eventImage;

    private final Picasso picasso;

//    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.fullDate();

    public EventListItem(@NonNull Context context, Picasso picasso) {
        super(context);
        this.picasso = picasso;
        inflate(getContext(), R.layout.list_item_event, this);
        ButterKnife.bind(this);
    }

    public void setEvent(Event event) {
//        Locale locale = getResources().getConfiguration().locale;

        title.setText(event.title);
        description.setText(event.description);
//        secretly dependant on
        picasso.load(event.imageUrl)
                .into(eventImage);
    }
}
