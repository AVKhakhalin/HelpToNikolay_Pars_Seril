package ru.geekbrains.lession6.edu_parcelable.logic;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class NewObjectArrayListParcelable implements Parcelable
{
    private ArrayList<String> text;

    public NewObjectArrayListParcelable(ArrayList<String> text)
    {
        this.text = text;
    }

    protected NewObjectArrayListParcelable(Parcel in) {
        text = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(text);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NewObjectArrayListParcelable> CREATOR = new Creator<NewObjectArrayListParcelable>() {
        @Override
        public NewObjectArrayListParcelable createFromParcel(Parcel in) {
            return new NewObjectArrayListParcelable(in);
        }

        @Override
        public NewObjectArrayListParcelable[] newArray(int size) {
            return new NewObjectArrayListParcelable[size];
        }
    };

    public ArrayList<String> getText() {
        return text;
    }

    public void setText(ArrayList<String> text) {
        this.text = text;
    }


}
