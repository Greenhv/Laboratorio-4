package com.example.labtel.laboratorio4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        final Button createContactBtn = (Button) findViewById(R.id.create_contact_btn);
        Button closeCreateContactBtn = (Button) findViewById(R.id.close_create_contact);

        createContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createContact(v);
            }
        });

        closeCreateContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMainActivity(v);
            }
        });
    }

    public void showMainActivity(View view) {finish();}

    private boolean checkTextField(EditText field, String fieldText, String errorMsg) {
        boolean answer = TextUtils.isEmpty(fieldText);
        if(answer)
            field.setError(errorMsg);
        return answer;
    }

    public void createContact(View view) {
        EditText nombreField = (EditText) findViewById(R.id.contact_nombre);
        EditText dniField = (EditText) findViewById(R.id.contact_dni);
        EditText correoField = (EditText) findViewById(R.id.contact_correo);
        EditText numeroField = (EditText) findViewById(R.id.contact_numero);

        String nombre = nombreField.getText().toString();
        String dni = dniField.getText().toString();
        String correo = correoField.getText().toString();
        String numero = numeroField.getText().toString();

        boolean checkFields = checkTextField(nombreField,nombre,"The name can't be blank") |
                              checkTextField(dniField,dni,"The dni can't be blank") |
                              checkTextField(correoField, correo, "The email can't be blank") |
                              checkTextField(numeroField, numero, "The number can't be blank");
        if(checkFields){
           return;
        } else {
            Contacto contacto = new Contacto(nombre, dni, correo, numero);
            contacto.save();
            finish();
        }

    }
}
