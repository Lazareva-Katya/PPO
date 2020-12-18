package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> products = new ArrayList<String>();
    ArrayList<String> selectedUsers = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        // добавляем начальные элементы
        Collections.addAll(products, "Молоко", "Сыр", "Колбаса", "Ананас");
        // получаем элемент ListView
        usersList = (ListView) findViewById(R.id.usersList);
        // создаем адаптер
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, products);
        // устанавливаем для списка адаптер
        usersList.setAdapter(adapter);

        // обработка установки и снятия отметки в списке
        usersList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // получаем нажатый элемент
                String user = adapter.getItem(position);
                if(usersList.isItemChecked(position))
                    selectedUsers.add(user);
                else
                    selectedUsers.remove(user);
            }
        });
    }

    public void add(View view){

        EditText userName = (EditText) findViewById(R.id.userName);
        String user = userName.getText().toString();
        if(!user.isEmpty()){
            adapter.add(user);
            userName.setText("");
            adapter.notifyDataSetChanged();
        }
    }
    public void remove(View view){
        // получаем и удаляем выделенные элементы
        for(int i=0; i< selectedUsers.size();i++){
            adapter.remove(selectedUsers.get(i));
        }
        // снимаем все ранее установленные отметки
        usersList.clearChoices();
        // очищаем массив выбраных объектов
        selectedUsers.clear();

        adapter.notifyDataSetChanged();
    }
}