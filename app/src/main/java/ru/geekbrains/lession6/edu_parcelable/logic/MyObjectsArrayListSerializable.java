package ru.geekbrains.lession6.edu_parcelable.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class MyObjectsArrayListSerializable implements Serializable {

    private String name;
    private int age;
    private ArrayList<String> address;
    private double[] sizes;
    private NewObjectSerializable newObjectSerializable;
    private ArrayList<NewObjectParcelableSerializble> addressObj;

    public MyObjectsArrayListSerializable(String name, int age, ArrayList<String> address, double[] sizes, NewObjectSerializable newObjectSerializable, ArrayList<NewObjectParcelableSerializble> addressObj) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
        this.sizes = sizes;
        this.newObjectSerializable = newObjectSerializable;
        this.addressObj = addressObj;
    }

    public ArrayList<String> getAddress() {
        if (!(address == null))
            return address;
        else
            return new ArrayList<String>();
    }

    public String getAddressObj() {
        String result = "";
        if (!(addressObj == null))
        {
            result += "[";
            for (int i = 0; i < addressObj.size(); i++)
            {
                result += (i < addressObj.size() - 1 ? String.format("%d, ", addressObj.get(i).getNewNumber()) : String.format("%d", addressObj.get(i).getNewNumber()));
            }
            result += "]";
        }
        return result;
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

    public NewObjectSerializable getNewObjectSerializable()
    {
        return newObjectSerializable;
    }

    public void setNewObjectSerializable(int first)
    {
        this.newObjectSerializable.setFirst(first);
    }
}
