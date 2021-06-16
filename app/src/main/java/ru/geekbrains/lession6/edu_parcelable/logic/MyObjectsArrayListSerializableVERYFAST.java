package ru.geekbrains.lession6.edu_parcelable.logic;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

public class MyObjectsArrayListSerializableVERYFAST implements Serializable {

    private String name;
    private int age;
    private NewObjectSerializable newObjectSerializable;

    public MyObjectsArrayListSerializableVERYFAST()
    {
        super();
    }

    public MyObjectsArrayListSerializableVERYFAST(String name, int age, NewObjectSerializable newObjectSerializable) {
        super();
        this.name = name;
        this.age = age;
        this.newObjectSerializable = newObjectSerializable;
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

    public NewObjectSerializable getNewObjectSerializable()
    {
        return newObjectSerializable;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException
    {
        out.writeUTF(name);
        out.writeInt(age);
        out.writeObject(newObjectSerializable);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        name = in.readUTF();
        age = in.readInt();
        newObjectSerializable = (NewObjectSerializable) in.readObject();
    }

    private void readObjectNoData() throws ObjectStreamException
    {
    }
}
