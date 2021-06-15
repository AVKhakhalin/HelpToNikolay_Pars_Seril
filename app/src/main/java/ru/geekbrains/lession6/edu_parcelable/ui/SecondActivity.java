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
        Log.d(LOG_TAG, "myObjectsArrayListParcelable: " + myObjectsArrayListParcelable.getAddress());
        Toast.makeText(this, String.format("%s, %s", myObjectsArrayListParcelable.getAddress(), myObjectsArrayListParcelable.getSizes()), Toast.LENGTH_SHORT).show();

        // Получение из intent класса myObjectStringIntParcelable
        MyObjectStringIntParcelable myObjectStringIntParcelable = (MyObjectStringIntParcelable) getIntent().getParcelableExtra(MyObjectStringIntParcelable.class.getCanonicalName());
        Log.d(LOG_TAG, "myObjectStringIntParcelable: " + myObjectStringIntParcelable.s + ", " + myObjectStringIntParcelable.i);
        Toast.makeText(this, String.format("%s, %d", myObjectStringIntParcelable.s, myObjectStringIntParcelable.i), Toast.LENGTH_SHORT).show();

        // Получение из intent класса myObjectsArrayListSerializable
        MyObjectsArrayListSerializable myObjectsArrayListSerializable = (MyObjectsArrayListSerializable) getIntent().getSerializableExtra("UniqueKey_3");
        Log.d(LOG_TAG, "myObjectsArrayListSerializable: " + myObjectsArrayListSerializable.getAddress());
        Toast.makeText(this, String.format("%s, %s, %d", myObjectsArrayListSerializable.getAddress(), myObjectsArrayListSerializable.getSizes(), myObjectsArrayListSerializable.getNewObjectSerializable()), Toast.LENGTH_SHORT).show();

        // Получение из intent класса myObjectsArrayListSerializable
        MyObjectsArrayListSerializableVERYFAST MyObjectsArrayListSerializableVERYFAST = (ru.geekbrains.lession6.edu_parcelable.logic.MyObjectsArrayListSerializableVERYFAST) getIntent().getSerializableExtra("UniqueKey_4");
        Log.d(LOG_TAG, "myObjectsArrayListSerializable: " + MyObjectsArrayListSerializableVERYFAST.getName() + ", " + MyObjectsArrayListSerializableVERYFAST.getAge());
        Toast.makeText(this, String.format("%s, %d", MyObjectsArrayListSerializableVERYFAST.getName(), MyObjectsArrayListSerializableVERYFAST.getAge()), Toast.LENGTH_SHORT).show();
    }
}