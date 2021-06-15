package ru.geekbrains.lession6.edu_parcelable.logic;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.Parcel;
import android.os.Parcelable;

public class MyObjectsArrayListParcelable implements Parcelable {

    private int age;
    private String name;
    private ArrayList<String> address;
    private double[] sizes;

    public MyObjectsArrayListParcelable(String name, int age, ArrayList<String> address, double[] sizes) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.sizes = sizes;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getAddress() {
        if (!(address == null))
            return address;
        else
            return new ArrayList<String>();
    }

    public String getSizes() {
        return Arrays.toString(sizes);
    }

    // Методы для сохранения и передачи класса
    public MyObjectsArrayListParcelable(Parcel source) {
        age = source.readInt();
        name = source.readString();
        address = source.createStringArrayList();
        sizes = source.createDoubleArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeString(name);
        dest.writeStringList(address);
        dest.writeDoubleArray(sizes);
    }

    @Override
    public int describeContents() {
        return 0;
    }


    public static final Creator<MyObjectsArrayListParcelable> CREATOR = new Creator<MyObjectsArrayListParcelable>() {
        @Override
        public MyObjectsArrayListParcelable[] newArray(int size) {
            return new MyObjectsArrayListParcelable[size];
        }

        @Override
        public MyObjectsArrayListParcelable createFromParcel(Parcel source) {
            return new MyObjectsArrayListParcelable(source);
        }
    };
}
