package com.cnb.learningdagger.network.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublicEventsResponse implements Parcelable
{

    @SerializedName("processStatus")
    @Expose
    public Integer processStatus;
    @SerializedName("resultObject")
    @Expose
    public ResultObject resultObject;
    @SerializedName("processDescription")
    @Expose
    public String processDescription;
    public final static Parcelable.Creator<PublicEventsResponse> CREATOR = new Creator<PublicEventsResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PublicEventsResponse createFromParcel(Parcel in) {
            return new PublicEventsResponse(in);
        }

        public PublicEventsResponse[] newArray(int size) {
            return (new PublicEventsResponse[size]);
        }

    }
            ;

    protected PublicEventsResponse(Parcel in) {
        this.processStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.resultObject = ((ResultObject) in.readValue((ResultObject.class.getClassLoader())));
        this.processDescription = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PublicEventsResponse() {
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(processStatus);
        dest.writeValue(resultObject);
        dest.writeValue(processDescription);
    }

    public int describeContents() {
        return 0;
    }

}