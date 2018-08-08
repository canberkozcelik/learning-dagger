package com.cnb.learningdagger.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event implements Parcelable
{

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("imageUrl")
    @Expose
    public String imageUrl;
    @SerializedName("maxParticipantCount")
    @Expose
    public Integer maxParticipantCount;
    @SerializedName("isInvitedShow")
    @Expose
    public Boolean isInvitedShow;
    @SerializedName("startDate")
    @Expose
    public String startDate;
    @SerializedName("endDate")
    @Expose
    public String endDate;
    @SerializedName("isPublic")
    @Expose
    public Boolean isPublic;
    @SerializedName("isDraft")
    @Expose
    public Boolean isDraft;
    @SerializedName("lastAttendanceDate")
    @Expose
    public String lastAttendanceDate;
    @SerializedName("tags")
    @Expose
    public List<Tag> tags = null;
    public final static Parcelable.Creator<Event> CREATOR = new Creator<Event>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        public Event[] newArray(int size) {
            return (new Event[size]);
        }

    }
            ;

    protected Event(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.imageUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.maxParticipantCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isInvitedShow = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.endDate = ((String) in.readValue((String.class.getClassLoader())));
        this.isPublic = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.isDraft = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.lastAttendanceDate = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.tags, (com.cnb.learningdagger.network.response.Tag.class.getClassLoader()));
    }

    public Event() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(description);
        dest.writeValue(imageUrl);
        dest.writeValue(maxParticipantCount);
        dest.writeValue(isInvitedShow);
        dest.writeValue(startDate);
        dest.writeValue(endDate);
        dest.writeValue(isPublic);
        dest.writeValue(isDraft);
        dest.writeValue(lastAttendanceDate);
        dest.writeList(tags);
    }

    public int describeContents() {
        return 0;
    }

}