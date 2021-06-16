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
    private NewObjectParcelableSerializble newObjectParcelableSerializble;
    private NewObjectArrayListParcelable newObjectArrayListParcelable;

    public MyObjectsArrayListParcelable(String name, int age, ArrayList<String> address, double[] sizes, NewObjectParcelableSerializble newObjectParcelableSerializble, NewObjectArrayListParcelable newObjectArrayListParcelable) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.sizes = sizes;
        this.newObjectParcelableSerializble = newObjectParcelableSerializble;
        this.newObjectArrayListParcelable = newObjectArrayListParcelable;
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

    public NewObjectParcelableSerializble getNewObjectParcelableSerializble() {
        return newObjectParcelableSerializble;
    }

    public void setNewObjectParcelableSerializble(NewObjectParcelableSerializble newObjectParcelableSerializble) {
        this.newObjectParcelableSerializble = newObjectParcelableSerializble;
    }

    public String getNewObjectArrayListParcelableValue() {
        String result = "";
        if (!(newObjectArrayListParcelable == null))
        {
            result += "[";
            for (int i = 0; i < newObjectArrayListParcelable.getText().size(); i++)
            {
                result += (i < newObjectArrayListParcelable.getText().size() - 1 ? (newObjectArrayListParcelable.getText().get(i) + ", ") : newObjectArrayListParcelable.getText().get(i));
            }
            result += "]";
        }
        return result;
    }

    public void setNewObjectArrayListParcelable(NewObjectArrayListParcelable newObjectArrayListParcelable) {
        this.newObjectArrayListParcelable = newObjectArrayListParcelable;
    }

    // Методы для сохранения и передачи класса
    public MyObjectsArrayListParcelable(Parcel source) {
        age = source.readInt();
        name = source.readString();
        address = source.createStringArrayList();
        sizes = source.createDoubleArray();
        newObjectParcelableSerializble = (NewObjectParcelableSerializble) source.readSerializable();
        newObjectArrayListParcelable = (NewObjectArrayListParcelable) source.readParcelable(getClass().getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeString(name);
        dest.writeStringList(address);
        dest.writeDoubleArray(sizes);
        dest.writeSerializable(newObjectParcelableSerializble);
        dest.writeParcelable(newObjectArrayListParcelable, flags);
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
