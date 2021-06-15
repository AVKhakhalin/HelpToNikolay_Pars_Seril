package ru.geekbrains.lession6.edu_parcelable.logic;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

public class MyObjectsArrayListSerializableVERYFAST implements Serializable {

    private String name;
    private int age;

    public MyObjectsArrayListSerializableVERYFAST()
    {
        super();
    }

    public MyObjectsArrayListSerializableVERYFAST(String name, int age, ArrayList<String> address, double[] sizes) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException
    {
        out.writeUTF(name);
        out.writeInt(age);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        name = in.readUTF();
        age = in.readInt();
    }

    private void readObjectNoData() throws ObjectStreamException
    {
    }
}
