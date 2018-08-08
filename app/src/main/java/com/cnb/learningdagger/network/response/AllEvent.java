package com.cnb.learningdagger.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllEvent implements Parcelable
{

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("loginRequired")
    @Expose
    public Boolean loginRequired;
    @SerializedName("locationReqired")
    @Expose
    public Boolean locationReqired;
    @SerializedName("events")
    @Expose
    public List<Event> events = null;
    public final static Parcelable.Creator<AllEvent> CREATOR = new Creator<AllEvent>() {


        @SuppressWarnings({
                "unchecked"
        })
        public AllEvent createFromParcel(Parcel in) {
            return new AllEvent(in);
        }

        public AllEvent[] newArray(int size) {
            return (new AllEvent[size]);
        }

    }
            ;

    protected AllEvent(Parcel in) {
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.loginRequired = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.locationReqired = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        in.readList(this.events, (com.cnb.learningdagger.network.response.Event.class.getClassLoader()));
    }

    public AllEvent() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(loginRequired);
        dest.writeValue(locationReqired);
        dest.writeList(events);
    }

    public int describeContents() {
        return 0;
    }

}