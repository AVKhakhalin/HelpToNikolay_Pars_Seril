package ru.geekbrains.lession6.edu_parcelable.logic;

import java.io.Serializable;

public class NewObjectSerializable implements Serializable
{
    int first;

    public NewObjectSerializable(int first)
    {
        this.first = first;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }
}
