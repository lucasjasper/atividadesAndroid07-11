package com.example.listadetarefas2telas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.listadetarefas2telas.R.layout.activity_salvar;

public class ActivitySalvar extends AppCompatActivity {

    EditText inputTarefa;
    Button botaoSalvar;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(activity_salvar);

        inputTarefa = findViewById(R.id.inputTarefa);
        botaoSalvar = findViewById(R.id.botaoSalvar);
        checkBox = findViewById(R.id.checkBox);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                telaLista(inputTarefa);

            }

        });

    }
    public void telaLista(EditText text) {

        String novaTarefa = text.getText().toString();

        if(!novaTarefa.equals("")){

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("tarefa", novaTarefa);
            intent.putExtra("bool", true);

            if(checkBox.isChecked()){

                intent.putExtra("cb", true);

            } else {

                intent.putExtra("cb", false);

            }

            startActivity(intent);

        }

    }

}