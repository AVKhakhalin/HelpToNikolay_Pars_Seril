package ru.geekbrains.lession6.edu_parcelable.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import ru.geekbrains.lession6.edu_parcelable.R;
import ru.geekbrains.lession6.edu_parcelable.logic.MyObjectStringIntParcelable;
import ru.geekbrains.lession6.edu_parcelable.logic.MyObjectsArrayListParcelable;
import ru.geekbrains.lession6.edu_parcelable.logic.MyObjectsArrayListSerializable;
import ru.geekbrains.lession6.edu_parcelable.logic.MyObjectsArrayListSerializableVERYFAST;

public class SecondActivity extends Activity
{
    final String LOG_TAG = "myLogs";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(LOG_TAG, "getParcelableExtra");

        // Получение из intent класса myObjectsArrayListParcelable
        MyObjectsArrayListParcelable myObjectsArrayListParcelable = (MyObjectsArrayListParcelable) getIntent().getParcelableExtra("UniqueKey_1");
        Log.d(LOG_TAG, "myObjectsArrayListParcelable: " + myObjectsArrayListParcelable.getAddress() + ", " + myObjectsArrayListParcelable.getSizes() + ", " + myObjectsArrayListParcelable.getNewObjectParcelableSerializble().getNewNumber() + ", " + myObjectsArrayListParcelable.getNewObjectArrayListParcelableValue());
        Toast.makeText(this, String.format("%s, %s, %d, %s", myObjectsArrayListParcelable.getAddress(), myObjectsArrayListParcelable.getSizes(), myObjectsArrayListParcelable.getNewObjectParcelableSerializble().getNewNumber(), myObjectsArrayListParcelable.getNewObjectArrayListParcelableValue()), Toast.LENGTH_SHORT).show();


        // Получение из intent класса myObjectStringIntParcelable
        MyObjectStringIntParcelable myObjectStringIntParcelable = (MyObjectStringIntParcelable) getIntent().getParcelableExtra(MyObjectStringIntParcelable.class.getCanonicalName());
        Log.d(LOG_TAG, "myObjectStringIntParcelable: " + myObjectStringIntParcelable.s + ", " + myObjectStringIntParcelable.i);
        Toast.makeText(this, String.format("%s, %d", myObjectStringIntParcelable.s, myObjectStringIntParcelable.i), Toast.LENGTH_SHORT).show();

        // Получение из intent класса myObjectsArrayListSerializable
        MyObjectsArrayListSerializable myObjectsArrayListSerializable = (MyObjectsArrayListSerializable) getIntent().getSerializableExtra("UniqueKey_3");
        Log.d(LOG_TAG, "myObjectsArrayListSerializable: " + myObjectsArrayListSerializable.getAddress() + ", " + myObjectsArrayListSerializable.getSizes() + ", " + myObjectsArrayListSerializable.getNewObjectSerializable().getFirst());
        Toast.makeText(this, String.format("%s, %s, %d, %s", myObjectsArrayListSerializable.getAddress(), myObjectsArrayListSerializable.getSizes(), myObjectsArrayListSerializable.getNewObjectSerializable().getFirst(), myObjectsArrayListSerializable.getAddressObj()), Toast.LENGTH_SHORT).show();

        // Получение из intent класса myObjectsArrayListSerializable
        MyObjectsArrayListSerializableVERYFAST myObjectsArrayListSerializableVERYFAST = (ru.geekbrains.lession6.edu_parcelable.logic.MyObjectsArrayListSerializableVERYFAST) getIntent().getSerializableExtra("UniqueKey_4");
        Log.d(LOG_TAG, "myObjectsArrayListSerializable: " + myObjectsArrayListSerializableVERYFAST.getName() + ", " + myObjectsArrayListSerializableVERYFAST.getAge() + ", " + myObjectsArrayListSerializableVERYFAST.getNewObjectSerializable().getFirst());
        Toast.makeText(this, String.format("%s, %d, %d", myObjectsArrayListSerializableVERYFAST.getName(), myObjectsArrayListSerializableVERYFAST.getAge(), myObjectsArrayListSerializableVERYFAST.getNewObjectSerializable().getFirst()), Toast.LENGTH_SHORT).show();
    }
}