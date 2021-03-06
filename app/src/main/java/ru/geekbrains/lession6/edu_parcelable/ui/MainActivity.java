package ru.geekbrains.lession6.edu_parcelable.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import ru.geekbrains.lession6.edu_parcelable.R;
import ru.geekbrains.lession6.edu_parcelable.logic.MyObjectStringIntParcelable;
import ru.geekbrains.lession6.edu_parcelable.logic.MyObjectsArrayListParcelable;
import ru.geekbrains.lession6.edu_parcelable.logic.MyObjectsArrayListSerializable;
import ru.geekbrains.lession6.edu_parcelable.logic.MyObjectsArrayListSerializableVERYFAST;
import ru.geekbrains.lession6.edu_parcelable.logic.NewObjectArrayListParcelable;
import ru.geekbrains.lession6.edu_parcelable.logic.NewObjectParcelableSerializble;
import ru.geekbrains.lession6.edu_parcelable.logic.NewObjectSerializable;

public class MainActivity extends Activity {

    final String LOG_TAG = "myLogs"; // Ключ нужен для ведения логирования (ЭТО НЕ ОБЯЗАТЕЛЬНО)

    MyObjectsArrayListParcelable myObjectsArrayListParcelable;              // Cоздание класса myObjectsArrayListParcelable для передачи через интерфейс Parcelable
    MyObjectStringIntParcelable myObjectStringIntParcelable;                // Cоздание класса myObjectStringIntParcelable для передачи через интерфейс Parcelable
    MyObjectsArrayListSerializable myObjectsArrayListSerializable;          // Создание класса myObjectsArrayListSerializable для передачи через интерфейс Serializable
    MyObjectsArrayListSerializableVERYFAST myObjectsArrayListSerializableVERYFAST;  // Создание класса myObjectsArrayListSerializableVERYFAST для передачи через интерфейс Serializable - это самый быстрый способ передать данные, он быстрее, чем Parcelable

    boolean isLandScape = true;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> listFirst1 = new ArrayList<>();
        listFirst1.add("one");
        listFirst1.add("two");
        listFirst1.add("tree");
        double[] arrayDouble1 = {0.5d, 57.75d};
        ArrayList<String> listFirst2 = new ArrayList<>();
        listFirst2.add("FOUR");
        listFirst2.add("FIVE");
        listFirst2.add("SIX");
        myObjectsArrayListParcelable = new MyObjectsArrayListParcelable("name", 20, listFirst1, arrayDouble1, new NewObjectParcelableSerializble(111), new NewObjectArrayListParcelable(listFirst2));

        ArrayList<String> listFirst3 = new ArrayList<>();
        listFirst3.add("ddd");
        listFirst3.add("TTT");
        listFirst3.add("BBB");
        double[] arrayDouble3 = {1.999d, 3938.698d};
        ArrayList<NewObjectParcelableSerializble> listObj = new ArrayList<>();
        listObj.add(new NewObjectParcelableSerializble(1000));
        listObj.add(new NewObjectParcelableSerializble(999));
        listObj.add(new NewObjectParcelableSerializble(888));
        myObjectsArrayListSerializable = new MyObjectsArrayListSerializable("another name", 99, listFirst3, arrayDouble3, new NewObjectSerializable(9), listObj);

        myObjectsArrayListSerializableVERYFAST = new MyObjectsArrayListSerializableVERYFAST("VERY FAST", 123456, new NewObjectSerializable(777));
    }

    public void onclick(View v) {
        Log.d(LOG_TAG, "startActivity");
        Intent intent = new Intent(this, SecondActivity.class);

        // Запись в intent класса myObjectsArrayListParcelable
        intent.putExtra("UniqueKey_1", myObjectsArrayListParcelable);

        // Запись в intent класса myObjectStringIntParcelable
        myObjectStringIntParcelable = new MyObjectStringIntParcelable("text", 1);
        intent.putExtra(MyObjectStringIntParcelable.class.getCanonicalName(), myObjectStringIntParcelable); // Записывается в Intent класс myObjectStringIntParcelable по ключу - Имя данного класса "myObjectStringIntParcelable"

        // Запись в intent класса myObjectsArrayListSerializable
        intent.putExtra("UniqueKey_3", myObjectsArrayListSerializable);

        // Запись в intent класса myObjectsArrayListSerializable
        intent.putExtra("UniqueKey_4", myObjectsArrayListSerializableVERYFAST);

        startActivity(intent);
    }
}