package com.example.ben.drawanote;

import android.os.Parcel;
import android.os.Parcelable;

public final class Doc implements Parcelable {

    private int mId;
    private String mTitle;
    private byte[] mImage;

    public Doc(int id, String title) {
        mId = id;
        mTitle = title;
    }

    public Doc(String title) {
        mTitle = title;
    }

    public Doc(byte[] image) {
        mImage = image;
    }

    private Doc(Parcel source) {
        mTitle = source.readString();
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public byte[] getImage() {
        return mImage;
    }
    public void setImage(byte[] image) {
        this.mImage = image;
    }

    private String getCompareKey() {
        return mTitle;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doc that = (Doc) o;

        return getCompareKey().equals(that.getCompareKey());

    }

    @Override
    public int hashCode() {
        return getCompareKey().hashCode();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
    }

    public static final Parcelable.Creator<Doc> CREATOR =
            new Parcelable.Creator<Doc>() {

                @Override
                public Doc createFromParcel(Parcel source) {
                    return new Doc(source);
                }

                @Override
                public Doc[] newArray(int size) {
                    return new Doc[size];
                }
            };

}
