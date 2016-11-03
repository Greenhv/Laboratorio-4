package com.example.labtel.laboratorio4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateTarea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tarea);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button closeBtn = (Button) findViewById(R.id.close_create_tarea);
        Button createTaskBtn = (Button) findViewById(R.id.create_tarea_btn);

        closeBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainActivity(v);
            }
        });

        createTaskBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTask(v);
            }
        });
    }

    public void showMainActivity(View view) {
        finish();
    }

    private boolean checkTextField(EditText field, String fieldText, String errorMsg) {
        boolean answer = TextUtils.isEmpty(fieldText);
        if(answer)
            field.setError(errorMsg);
        return answer;
    }

    public void createTask(View view) {
        EditText tituloField = (EditText) findViewById(R.id.titulo);
        EditText fechaInicioField = (EditText) findViewById(R.id.fecha_inicio);
        EditText fechaFinField = (EditText) findViewById(R.id.fecha_fin);
        EditText listaItemsField = (EditText) findViewById(R.id.lista_items);

        String titulo = tituloField.getText().toString();
        String fechaInicio = fechaInicioField.getText().toString();
        String fechaFin = fechaFinField.getText().toString();
        String listaItems = listaItemsField.getText().toString();

        boolean checkFields =  checkTextField(tituloField, titulo, "The title can't be blank") |
                               checkTextField(fechaInicioField, fechaInicio, "The start date can't be blank") |
                               checkTextField(fechaFinField, fechaFin, "The end date can't be blank") |
                               checkTextField(listaItemsField, listaItems, "The list of items can't be blank");
        if(checkFields){
            return;
        } else {
            Task nuevaTask = new Task(titulo,fechaInicio,fechaFin,listaItems);
            nuevaTask.save();
            finish();
        }
    }
}
