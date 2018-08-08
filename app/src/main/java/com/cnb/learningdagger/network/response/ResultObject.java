package com.cnb.learningdagger.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultObject implements Parcelable
{

    @SerializedName("allEvents")
    @Expose
    public List<AllEvent> allEvents = null;
    public final static Parcelable.Creator<ResultObject> CREATOR = new Creator<ResultObject>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ResultObject createFromParcel(Parcel in) {
            return new ResultObject(in);
        }

        public ResultObject[] newArray(int size) {
            return (new ResultObject[size]);
        }

    }
            ;

    protected ResultObject(Parcel in) {
        in.readList(this.allEvents, (com.cnb.learningdagger.network.response.AllEvent.class.getClassLoader()));
    }

    public ResultObject() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(allEvents);
    }

    public int describeContents() {
        return 0;
    }

}