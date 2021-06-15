package ru.geekbrains.lession6.edu_parcelable.logic;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class MyObjectStringIntParcelable implements Parcelable {

    final static String LOG_TAG = "myLogs";

    public String s;
    public int i;

    // обычный конструктор
    public MyObjectStringIntParcelable(String _s, int _i) {
        Log.d(LOG_TAG, "MyObject(String _s, int _i)");
        s = _s;
        i = _i;
    }

    public int describeContents() {
        return 0;
    }

    // упаковываем объект в Parcel
    public void writeToParcel(Parcel parcel, int flags) {
        Log.d(LOG_TAG, "writeToParcel");
        parcel.writeString(s);
        parcel.writeInt(i);
    }

    public static final Parcelable.Creator<MyObjectStringIntParcelable> CREATOR = new Parcelable.Creator<MyObjectStringIntParcelable>() {
        // распаковываем объект из Parcel
        public MyObjectStringIntParcelable createFromParcel(Parcel in) {
            Log.d(LOG_TAG, "createFromParcel");
            return new MyObjectStringIntParcelable(in);
        }

        public MyObjectStringIntParcelable[] newArray(int size) {
            return new MyObjectStringIntParcelable[size];
        }
    };

    // конструктор, считывающий данные из Parcel
    private MyObjectStringIntParcelable(Parcel parcel) {
        Log.d(LOG_TAG, "MyObject(Parcel parcel)");
        s = parcel.readString();
        i = parcel.readInt();
    }

}