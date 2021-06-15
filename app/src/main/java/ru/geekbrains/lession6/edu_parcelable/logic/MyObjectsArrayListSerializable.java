package ru.geekbrains.lession6.edu_parcelable.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class MyObjectsArrayListSerializable implements Serializable {

    private String name;
    private int age;
    private ArrayList<String> address;
    private double[] sizes;

    public MyObjectsArrayListSerializable(String name, int age, ArrayList<String> address, double[] sizes) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
        this.sizes = sizes;
    }

    public ArrayList<String> getAddress() {
        if (!(address == null))
            return address;
        else
            return new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSizes()
    {
        return Arrays.toString(sizes);
    }
}
