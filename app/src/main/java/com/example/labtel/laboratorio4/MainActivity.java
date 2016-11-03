package com.example.labtel.laboratorio4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView agenda;
    private ListView tasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      Tab SetUp
        TabHost tabsHost = (TabHost) findViewById(R.id.tabHost);
        TabSpec tab1 = tabsHost.newTabSpec("Contactos");
        TabSpec tab2 = tabsHost.newTabSpec("Tareas");
        tabsHost.setup();
        tab1.setIndicator("CONTACTOS");
        tab1.setContent(R.id.Contactos);
        tab2.setIndicator("TAREAS");
        tab2.setContent(R.id.Tareas);
        tabsHost.addTab(tab1);
        tabsHost.addTab(tab2);
//
        Button openCreateContact = (Button) findViewById(R.id.open_create_contact);
        Button openCreateTask = (Button) findViewById(R.id.open_create_task);

        openCreateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCreateContact(v);
            }
        });

        openCreateTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCreateTask(v);
            }
        });
        // Populate Contact List
        ArrayList<Contacto> contactList = new ArrayList<Contacto>(Contacto.listAll(Contacto.class));
        ContactAdapter contactAdapter = new ContactAdapter(getApplicationContext(),contactList);
        this.agenda = (ListView) findViewById(R.id.contact_list);
        this.agenda.setAdapter(contactAdapter);
        // Populate Taks List
        ArrayList<Task> taskList = new ArrayList<Task>(Task.listAll(Task.class));
        TaskAdapter taskAdapter = new TaskAdapter(getApplicationContext(), taskList);
        this.tasks = (ListView) findViewById(R.id.task_list);
        this.tasks.setAdapter(taskAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Update Contact List
        ArrayList<Contacto> contactList = new ArrayList<Contacto>(Contacto.listAll(Contacto.class));
        ContactAdapter contactAdapter = new ContactAdapter(getApplicationContext(),contactList);
        this.agenda = (ListView) findViewById(R.id.contact_list);
        this.agenda.setAdapter(contactAdapter);
        // Update the Task List
        ArrayList<Task> taskList = new ArrayList<Task>(Task.listAll(Task.class));
        TaskAdapter taskAdapter = new TaskAdapter(getApplicationContext(), taskList);
        this.tasks = (ListView) findViewById(R.id.task_list);
        this.tasks.setAdapter(taskAdapter);
    }

    public void showCreateTask(View view) {
        Intent intent = new Intent(this, CreateTarea.class);
        startActivity(intent);
    }

    public void showCreateContact(View view) {
        Intent intent = new Intent(this, CreateContact.class);
        startActivity(intent);
    }
}
