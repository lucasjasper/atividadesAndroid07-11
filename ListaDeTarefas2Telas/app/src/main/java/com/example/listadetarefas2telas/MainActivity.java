package com.example.listadetarefas2telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.listadetarefas2telas.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter adapter;
    ListView listTarefa;
    Button botaoIncluir;

    boolean teste, checkBox;
    Intent intent;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        botaoIncluir = findViewById(R.id.botaoIncluir);

        listTarefa = findViewById(R.id.listTarefa);
        listTarefa.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        intent = getIntent();

        teste = intent.getBooleanExtra("bool", false);
        checkBox = intent.getBooleanExtra("cb", false);
        String tarefa = intent.getStringExtra("tarefa");

        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_multiple_choice, Tarefa.tarefas);
        listTarefa.setAdapter(adapter);

        if (teste) {

            i = IndexState.INSTANCE.getIndex();
            Tarefa.tarefas.add(i, tarefa);

            adapter.notifyDataSetChanged();

            if (checkBox)
                listTarefa.setItemChecked(i, true);

            teste = false;

            IndexState.INSTANCE.setIndex(1);
        }

        botaoIncluir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                telaSalvar();

            }

        });

    }

    static class Tarefa{

        static ArrayList<String> tarefas = new ArrayList<>();

    }

    static class WhatIsChecked{

        static int[] check= {};

    }

    public enum IndexState{

        INSTANCE;
        int index = 0;

        public int getIndex(){
            return index;
        }
        public void setIndex(int index){
            this.index += index;
        }

    }

    public enum CheckIndexState{

        INSTANCE;
        int index = 0;

        public int getIndex(){
            return index;
        }
        public void setIndex(int index){
            this.index += index;
        }

    }

    public void telaSalvar() {

        Intent intent = new Intent(this, ActivitySalvar.class);
        startActivity(intent);

    }

}